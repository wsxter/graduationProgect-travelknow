package cn.wsxter.dao;

import cn.wsxter.domain.Customer;

//操作数据库中User表中的类
public interface UserDao {
    Customer findUserByUsernameAndPassword(String username, String password);
    void addUser(Customer customer);


    Customer findbyUsername(String username);
}
