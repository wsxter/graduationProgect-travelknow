package cn.wsxter.service.Impl;

import cn.wsxter.dao.AnswerDao;
import cn.wsxter.dao.CategoryDao;
import cn.wsxter.dao.FADao;
import cn.wsxter.dao.Impl.AnswerDaoImp;
import cn.wsxter.dao.Impl.CategoryDaoImp;
import cn.wsxter.dao.Impl.FADaoImp;
import cn.wsxter.dao.Impl.QuestionDaoImp;
import cn.wsxter.dao.QuestionDao;
import cn.wsxter.domain.*;

import cn.wsxter.service.FAService;

import java.util.List;

public class FAServiceImp implements FAService {
    private FADao faDao = new FADaoImp();
    @Override
    public void addAnswer(falseanswer answer) {
        faDao.addAnswer(answer);
    }

    @Override
    public void delanswer(String answer_id) {
        faDao.delAanswer(answer_id);
    }

    @Override
    public void addAnswertrue(String answer_id) {
        //找到这条回答
        falseanswer findbyid = faDao.findbyid(answer_id);
        //建立一个真正回答的Dao对象
        AnswerDao answerDao = new AnswerDaoImp();
        //真正回答的对象
        Answer answer = new Answer();//uid /qname /acontent/place_name
        //真正回答添加回答
        answer.setAnswer_content(findbyid.getAnswer_content());
        //真正回答添加回答用户
        answer.setUser_id(findbyid.getUser_id());
        //有问题
        if (findbyid.getQues_name() != null) {

            //创建地点Dao对象
            CategoryDao categoryDao = new CategoryDaoImp();
            place findplace = new place();
            //有地点
            if (findbyid.getPlace_name() != null&&findbyid.getPlace_name().length() > 0 ) {

                //找这个地点的数据
                findplace = categoryDao.findbyname(findbyid.getPlace_name());
                //创建一个问题Dao对象

                //如果数据 库没有这个Dao对象
                if (findplace == null) {
                    //添加这个地点
                    categoryDao.addplace(findbyid.getPlace_name());
                    findplace = categoryDao.findbyname(findbyid.getPlace_name());

                }
                } else {
                    findplace = categoryDao.findbyname("火星");
                }
                QuestionDao questionDao = new QuestionDaoImp();
                //再次查询，找到id

                int place_id = findplace.getPlace_id();
                //查询问题表，
                Question quesfindbyname = questionDao.findbyname(findbyid.getQues_name(), place_id);
                //如果没有这个问题
                if (quesfindbyname == null) {
                    //添加这个问题
                    questionDao.addques(findbyid.getQues_name(), findbyid.getQues_describle(), findplace.getPlace_id(), findbyid.getUser_id());
                }
                //返回问题id
                Question quesfindbyname1 = questionDao.findbyname(findbyid.getQues_name(), place_id);
                answer.setQuestion_id(quesfindbyname1.getQuestion_id());//添加question_id
                answerDao.updateAnswer(answer);


            }

            faDao.delAanswer(answer_id);


        }

    @Override
    public PageBean<falseanswer> findAnswer(int currentPage, int pageSize) {
        //已有 place_id 页面显示条数pagesize  当前页码currentPage
        //需要 private int totalCount;//总记录数
        //    private int totalPage;//总页数
        //    private int currentPage;//当前页码
        //    private int pageSize;//每页显示的条数
        //    private List<T> list;//页面上显示的数据集合
        PageBean<falseanswer> pb = new PageBean<>();


        //总记录数
        int totalCount = faDao.findTotalCount();
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
        List<falseanswer> byPage = faDao.findByPage(start, pageSize);
        pb.setList(byPage);


        return pb;
    }
}
