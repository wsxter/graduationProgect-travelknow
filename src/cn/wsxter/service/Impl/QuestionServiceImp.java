package cn.wsxter.service.Impl;

import cn.wsxter.dao.Impl.QuestionDaoImp;
import cn.wsxter.dao.QuestionDao;
import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.Question;
import cn.wsxter.service.QuestionService;

import java.util.List;

public class QuestionServiceImp implements QuestionService {
    private QuestionDao questionDao = new QuestionDaoImp();


    @Override
    public PageBean<Question> pageQuery(int place_id, int pageSize, int currentPage) {
        //已有 place_id 页面显示条数pagesize  当前页码currentPage
        //需要 private int totalCount;//总记录数
        //    private int totalPage;//总页数
        //    private int currentPage;//当前页码
        //    private int pageSize;//每页显示的条数
        //    private List<T> list;//页面上显示的数据集合
        PageBean<Question> pb = new PageBean<Question>();

        //总记录数
        int totalCount = questionDao.findTotalCount(place_id);
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
        List<Question> byPage = questionDao.findByPage(place_id, start, pageSize);
        pb.setList(byPage);
        return pb;

    }



}
