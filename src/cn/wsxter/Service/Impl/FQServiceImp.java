package cn.wsxter.Service.Impl;

import cn.wsxter.dao.CategoryDao;
import cn.wsxter.dao.FQDao;
import cn.wsxter.dao.Impl.CategoryDaoImp;
import cn.wsxter.dao.Impl.FQDaoImp;
import cn.wsxter.dao.Impl.QuestionDaoImp;
import cn.wsxter.dao.QuestionDao;
import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.falseques;
import cn.wsxter.domain.place;
import cn.wsxter.Service.FQService;

import java.util.List;

public class FQServiceImp implements FQService {
    private FQDao fqDao = new FQDaoImp();

    @Override
    public PageBean<falseques> findQues(int currentPage, int pageSize) {
        //已有 place_id 页面显示条数pagesize  当前页码currentPage
        //需要 private int totalCount;//总记录数
        //    private int totalPage;//总页数
        //    private int currentPage;//当前页码
        //    private int pageSize;//每页显示的条数
        //    private List<T> list;//页面上显示的数据集合
        PageBean<falseques> pb = new PageBean<>();


        //总记录数
        int totalCount = fqDao.findTotalCount();
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
        List<falseques> byPage = fqDao.findByPage(start, pageSize);
        pb.setList(byPage);


        return pb;

    }

    @Override
    public void delques(int parseInt) {
        fqDao.delques(parseInt);
    }

    @Override
    public void addques(int parseInt) {
        falseques findbyid = fqDao.findbyid(parseInt);

        CategoryDao categoryDao = new CategoryDaoImp();
        place findbyname = categoryDao.findbyname(findbyid.getPlace_name());
        QuestionDao questionDao = new QuestionDaoImp();
        if (findbyname == null){
            categoryDao.addplace(findbyid.getPlace_name());

        }
        place findplace = categoryDao.findbyname(findbyid.getPlace_name());
        questionDao.addques(findbyid.getQues_name(),findbyid.getQues_describle(),findplace.getPlace_id(),findbyid.getUser_id());


        fqDao.delques(parseInt);



    }

    @Override
    public void userAddQues(falseques falseques) {

        fqDao.userAddQues(falseques);
    }
}
