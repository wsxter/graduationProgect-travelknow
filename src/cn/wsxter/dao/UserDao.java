package cn.wsxter.dao;

import cn.wsxter.domain.Customer;

import java.util.List;

//操作数据库中User表中的类
public interface UserDao {
    Customer findUserByUsernameAndPassword(String username, String password);
    void addUser(Customer customer);


    Customer findbyUsername(String username);
    Customer findbuUserid(int userid);

    String findbyUserid(int user_id);

    int findTotalCount();

    List<Customer> findByPage(int start, int pageSize);

    void deluser(int user_id);

    void gooduser(int user_id);

    void update(String username, int sex, String password, String email, String sign,int user_id);
}
