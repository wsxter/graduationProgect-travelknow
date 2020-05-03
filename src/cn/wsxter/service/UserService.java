package cn.wsxter.service;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.PageBean;

public interface UserService {
    Customer login(Customer customer);

   boolean  addUser(Customer customer);


    PageBean<Customer> pageQuery(int pageSize, int currentPage);

    Customer finduserbyid(int parseInt);

    String finuserid(int parseInt);

    void deluser(int user_id, int status);

    void updateUser(String username, int sex, String password, String email, String sign,int user_id);

}
