package cn.wsxter.dao;

import cn.wsxter.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

//操作数据库中User表中的类
@Repository
public interface UserDao {

    //添加用户
   void addUser(Customer customer);

   List<Customer> finduser(Customer customer);

    //查询用户个数
   int findTotalCount();

    //limit 查找，传入开始页码star  和 size大小
    List<Customer> findByPage(HashMap map);

    //删除用户
    void deluser(int user_id);

    //设置用户状态status为1
    void gooduser(int user_id);

    //更新用户
    void update(Customer customer);
}
