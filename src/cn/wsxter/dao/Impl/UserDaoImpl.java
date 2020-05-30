package cn.wsxter.dao.Impl;

import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.Customer;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Customer findUserByUsernameAndPassword(String username, String password) {
        Customer customer = null;
        try {
            String sql = "select * from customer where username = ? and password = ?";
            customer = template.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;

    }

    @Override
    public void addUser(Customer customer) {
       String sql = "insert into customer (username,password,email,create_time) VALUES (?,?,?,?)";
        template.update(sql,  customer.getUsername(), customer.getPassword(),customer.getEmail(),date());
    }

    @Override
    public Customer findbyUsername(String username) {
        try {
            String sql = "select * from customer where username = ?";
            Customer customer = template.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), username);
            return customer;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Customer findbuUserid(int userid) {
        try {
            String sql = "select * from customer where user_id = ?";
            Customer customer = template.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), userid);
            return customer;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String findbyUserid(int user_id) {
        String sql = " select username from customer where user_id = ? ";
        String name = template.queryForObject(sql,String.class,user_id);
        return name;
    }

    @Override
    public int findTotalCount() {
        String sql = " select count(*) from customer  ";
         return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Customer> findByPage(int start, int pageSize) {
        String sql = "select * from customer limit ?,? ";
        List<Customer> query = template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class), start, pageSize);
        return  query;
    }

    @Override
    public void deluser(int user_id) {
        String sql = "update customer set status = 0 where user_id = ?";
        template.update(sql,user_id);
    }

    @Override
    public void gooduser(int user_id) {
        String sql = "update customer set status = 1 where user_id = ?";
        template.update(sql,user_id);
    }


    @Override
    public void update(String username, int sex, String password, String email, String sign,int user_id) {
        String sql = "update customer set username = ? , password = ? , email = ? , autograph = ? , role = ? where user_id = ?";
        template.update(sql,username,password,email,sign,sex,user_id);
    }
}