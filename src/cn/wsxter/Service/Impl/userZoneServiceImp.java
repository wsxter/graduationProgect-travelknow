package cn.wsxter.Service.Impl;

import cn.wsxter.dao.*;
import cn.wsxter.dao.Impl.*;
import cn.wsxter.domain.*;
import cn.wsxter.Service.userZoneService;

import java.util.ArrayList;
import java.util.List;

public class userZoneServiceImp implements userZoneService {
    private AnswerDao answerDao = new AnswerDaoImp();
    private QuestionDao questionDao = new QuestionDaoImp();
    private CollectDao collectDao = new CollectDaoImp();
    private AttendDao attendDao = new AttendDaoImp();
    private CategoryDao categoryDao = new CategoryDaoImp();
    @Override
    public PageBean userZoneQuery(Integer user_id, int currentPage, int pageSize, int buttonCetogry) {
        PageBean pb = new PageBean();
        pb.setCurrentPage(currentPage);

        pb.setPageSize(pageSize);

        int start = (currentPage - 1 ) * pageSize;
        if (buttonCetogry == 1){
            int totalCount = answerDao.findTotalCountbyUserId(user_id);
            pb.setTotalCount(totalCount);


            List quname = new ArrayList();
            List<Answer> list = answerDao.findByPageUser(user_id,start,pageSize);
            pb.setList(list);
            for (Answer i : list){
                Question one = questionDao.findOne(i.getQuestion_id());
                quname.add(one.getQuestion_name());
            }

            pb.setPlace_name(quname);

            int totalPage = totalCount % pageSize == 0 ? totalCount /pageSize : (totalCount / pageSize) + 1;
            pb.setTotalPage(totalPage);
            return pb;
        }else if (buttonCetogry == 2){
            List place_list = new ArrayList();
            int totalCount = questionDao.findTotalCountbyUserId(user_id);
            pb.setTotalCount(totalCount);



            List<Question> list = questionDao.findByPageUser(user_id,start,pageSize);
            for (Question q : list){
                place one = categoryDao.findOne(q.getOpicId());
                place_list.add(one.getPlace_name());
            }
            pb.setList(list);
            pb.setPlace_name(place_list);

            int totalPage = totalCount % pageSize == 0 ? totalCount /pageSize : (totalCount / pageSize) + 1;
            pb.setTotalPage(totalPage);
            return pb;
        }else if (buttonCetogry == 3){
            int totalCount = collectDao.collect_num(user_id);
            pb.setTotalCount(totalCount);


            List<Collect> list = collectDao.findByPageUser(user_id,start,pageSize);
            pb.setList(list);

            int totalPage = totalCount % pageSize == 0 ? totalCount /pageSize : (totalCount / pageSize) + 1;
            pb.setTotalPage(totalPage);
            return pb;
        }else if (buttonCetogry == 4){
            int totalCount = attendDao.findTotalCountbyUserId(user_id);
            pb.setTotalCount(totalCount);

            List li = new ArrayList();
            List place_lis = new ArrayList();
            List<Attendquestion> listbyquesname = attendDao.findByPageUser(user_id);
            for (Attendquestion i : listbyquesname){
                Question question= questionDao.findOne( i.getQuestion_id());
                place one = categoryDao.findOne(question.getOpicId());
                li.add(question);
                place_lis.add(one.getPlace_name());
            }
            pb.setList(li);
            pb.setPlace_name(place_lis);

            int totalPage = totalCount % pageSize == 0 ? totalCount /pageSize : (totalCount / pageSize) + 1;
            pb.setTotalPage(totalPage);
            return  pb;

        }







      return null;
    }
}
