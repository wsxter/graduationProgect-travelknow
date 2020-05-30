package cn.wsxter.Service.Impl;

import cn.wsxter.dao.Impl.RecommendDaoImpl;
import cn.wsxter.dao.RecommendDao;
import cn.wsxter.domain.Recommend;
import cn.wsxter.domain.indexPageBean;
import cn.wsxter.Service.AnswerService;
import cn.wsxter.Service.QuestionService;
import cn.wsxter.Service.RecommendService;

import java.util.*;

public class RecommendServiceImpl implements RecommendService {
    private RecommendDao recommendDao = new RecommendDaoImpl();
    private AnswerService answerService = new AnswerServiceImp();
    private QuestionService questionService = new QuestionServiceImp();
    @Override
    public List res_Query(int Page_size,int current_Page) {

        List<Object> list = new ArrayList<>();
        int Star = Page_size *(current_Page - 1);
        List<Recommend> recommends = recommendDao.rec_list(Star,Page_size);



        for (Recommend ob : recommends){
            indexPageBean indexPageBean = new indexPageBean();
            if (ob.getAnswer_id() !=null) {
                indexPageBean = answerService.answerQuery(ob.getAnswer_id());

            }
            if (ob.getQuestion_id() !=null){
                indexPageBean = questionService.questionQuery(ob.getQuestion_id());

            }
            list.add(indexPageBean);
        }


        return list;

    }
}
