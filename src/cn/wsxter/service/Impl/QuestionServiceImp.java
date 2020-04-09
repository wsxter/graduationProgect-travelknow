package cn.wsxter.service.Impl;


import cn.wsxter.dao.CategoryDao;
import cn.wsxter.dao.Impl.CategoryDaoImp;
import cn.wsxter.dao.Impl.QuestionDaoImp;
import cn.wsxter.dao.Impl.UserDaoImpl;
import cn.wsxter.dao.QuestionDao;
import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.*;
import cn.wsxter.service.QuestionService;

import java.util.List;

public class QuestionServiceImp implements QuestionService {
    private QuestionDao questionDao = new QuestionDaoImp();



    @Override
    public PageBean<Question> pageQuery(int place_id, int pageSize, int currentPage, String question_name) {
        //已有 place_id 页面显示条数pagesize  当前页码currentPage
        //需要 private int totalCount;//总记录数
        //    private int totalPage;//总页数
        //    private int currentPage;//当前页码
        //    private int pageSize;//每页显示的条数
        //    private List<T> list;//页面上显示的数据集合
        PageBean<Question> pb = new PageBean<Question>();

        //总记录数
        int totalCount = questionDao.findTotalCount(place_id,question_name);
        pb.setTotalCount(totalCount);
        //总页数
        pb.setTotalPage(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1 );
        //当前页码 currentPage
        pb.setCurrentPage(currentPage);
        //每页显示条数
        pb.setPageSize(pageSize);
        //数据集合
        //l=开始页数
        int start = (currentPage - 1 ) * pageSize;
        List<Question> byPage = questionDao.findByPage(place_id, start, pageSize,question_name);
        pb.setList(byPage);

        return pb;

    }

    @Override
    public PageBean<Question> newestpageQuery(int pageSize, int currentPage) {
        PageBean<Question> pb = new PageBean<Question>();

        //总记录数
        int totalCount = questionDao.totalcount();
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1 );
        //当前页码 currentPage
        pb.setCurrentPage(currentPage);
        //每页显示条数
        pb.setPageSize(pageSize);
        //数据集合
        //l=开始页数
        int start = (currentPage - 1 ) * pageSize;
        List<Question> byPage = questionDao.findNewest(start, pageSize);
        pb.setList(byPage);

        return pb;
    }

    @Override
    public Question findOne(int question_id) {
        return questionDao.findOne(question_id);
    }

    @Override
    public indexPageBean questionQuery(int question_id) {
        Question one = questionDao.findOne(question_id);
        indexPageBean indexPageBean = new indexPageBean();
        indexPageBean.setQuestion(one);
        UserDao userDao = new UserDaoImpl();
        Customer customer = userDao.findbuUserid(one.getUser_id());
        indexPageBean.setUsername(customer.getUsername());
        CategoryDao categoryDao = new CategoryDaoImp();
        place one1 = categoryDao.findOne(one.getOpicId());
        indexPageBean.setPlace_name(one1.getPlace_name());
       /* Answer answer = answerDao.answer_query(answer_id);
        indexPageBean indexPageBean = new indexPageBean();
        indexPageBean.setAnswer(answer);
        Customer customer = userDao.findbuUserid(answer.getUser_id());
        indexPageBean.setUsername(customer.getUsername());

        QuestionDao questionDao = new QuestionDaoImp();
        Question one = questionDao.findOne(answer.getQuestion_id());
        indexPageBean.setQuestion_name(one.getQuestion_name());*/
        return indexPageBean;
    }

    @Override
    public List<Question> find_hot() {
        return questionDao.find_hot();
    }


}
