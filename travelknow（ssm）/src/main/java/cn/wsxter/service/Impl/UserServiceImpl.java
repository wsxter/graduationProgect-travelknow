package cn.wsxter.service.Impl;



import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.Customer;
import cn.wsxter.domain.PageBean;
import cn.wsxter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

//import org.apache.taglibs.standard.lang.jstl.NullLiteral;
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    @Override
    public Customer login(Customer customer) {
        List<Customer> finduser = dao.finduser(customer);
        return finduser.get(0);
    }

    @Override
    public boolean addUser(Customer customer) {
        /*List<Customer> finduser = dao.finduser(customer);
        Customer customer1 = finduser.get(0);
        if (customer1 != null){
            return false;
        }else {*/
            dao.addUser(customer);
            return true;

       /* }*/


    }


    @Override
    public PageBean<Customer> pageQuery(int pageSize, int currentPage) {
        //已有 place_id 页面显示条数pagesize  当前页码currentPage
        //需要 private int totalCount;//总记录数
        //    private int totalPage;//总页数
        //    private int currentPage;//当前页码
        //    private int pageSize;//每页显示的条数
        //    private List<T> list;//页面上显示的数据集合
        PageBean<Customer> pb = new PageBean<Customer>();

        //总记录数
        int totalCount = dao.findTotalCount();
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
        HashMap<String,Object> map = new HashMap<>();
        map.put("star",start);
        map.put("pageSize",pageSize);
        List<Customer> byPage = dao.findByPage(map);
        pb.setList(byPage);

        return pb;

    }

    @Override
    public Customer finduser(Customer customer) {
        List<Customer> finduser = dao.finduser(customer);
        return finduser.get(0);
    }

    @Override
    public String finuserid(int parseInt) {
        return null;
    }

    @Override
    public void deluser(int user_id, int status) {
        if (status == 1){
            dao.deluser(user_id);
        }
        else {
            dao.gooduser(user_id);
        }

    }

    @Override
    public void updateUser(Customer customer) {

        dao.update(customer);
    }


}