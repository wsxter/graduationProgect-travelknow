package cn.wsxter.service.Impl;

import cn.wsxter.dao.AnswerDao;
import cn.wsxter.dao.CollectDao;
import cn.wsxter.dao.Impl.AnswerDaoImp;
import cn.wsxter.dao.Impl.CollectDaoImp;
import cn.wsxter.dao.Impl.QuestionDaoImp;
import cn.wsxter.dao.QuestionDao;
import cn.wsxter.domain.Answer;
import cn.wsxter.domain.Question;
import cn.wsxter.domain.ResultInfo;
import cn.wsxter.service.CollectService;
import sun.dc.pr.PRError;

public class CollectServiceImp implements CollectService {
    private CollectDao collectDao = new CollectDaoImp();
    private AnswerDao answerDao = new AnswerDaoImp();
    private QuestionDao questionDao = new QuestionDaoImp();
    ResultInfo resultInfo = new ResultInfo();
    @Override
    public ResultInfo findCollect(int parseInt, Integer user_id) {
        int collect = collectDao.findCollect(parseInt, user_id);
        if (collect < 1){
            Answer answer = answerDao.answer_query(parseInt);
            Question one = questionDao.findOne(answer.getQuestion_id());
            collectDao.addCollect(answer.getAnswer_content(),one.getQuestion_name(),user_id,parseInt);

            resultInfo.setFlag(true);
            resultInfo.setErrorMsg("已收藏");

        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("。。。。。");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo loadfindCollect(int parseInt, Integer user_id) {
        int collect = collectDao.findCollect(parseInt, user_id);
        if (collect < 1){

            resultInfo.setFlag(false);


        }else {
            resultInfo.setFlag(true);
            resultInfo.setErrorMsg("取消收藏");
        }
        return resultInfo;
    }

    @Override
    public int collect_num(Integer user_id) {
        return collectDao.collect_num(user_id);
    }
}
