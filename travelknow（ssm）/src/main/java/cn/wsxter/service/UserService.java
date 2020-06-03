package cn.wsxter.service;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.PageBean;
import org.springframework.stereotype.Service;


public interface UserService {
    Customer login(Customer customer);

   boolean  addUser(Customer customer);


    PageBean<Customer> pageQuery(int pageSize, int currentPage);

    Customer finduser(Customer customer);

    String finuserid(int parseInt);

    void deluser(int user_id, int status);

    void updateUser(Customer customer);

}
