package cn.wsxter.service.Impl;

import cn.wsxter.dao.AnswerDao;
import cn.wsxter.dao.Impl.AnswerDaoImp;
import cn.wsxter.dao.Impl.UserDaoImpl;
import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.Answer;
import cn.wsxter.domain.PageBean;
import cn.wsxter.service.AnswerService;

import java.util.List;

public class AnswerServiceImp implements AnswerService {
    private AnswerDao answerDao = new AnswerDaoImp();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public PageBean<Answer> pageQuery(int question_id, int pageSize, int currentPage) {
        PageBean<Answer> pb = new PageBean<Answer>();
        //

        pb.setCurrentPage(currentPage);

        pb.setPageSize(pageSize);

        int totalCount = answerDao.findTotalCount(question_id);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1 ) * pageSize;
        List<Answer> list = answerDao.findByPage(question_id,start,pageSize);
        pb.setList(list);

        int totalPage = totalCount % pageSize == 0 ? totalCount /pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
