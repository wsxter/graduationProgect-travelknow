package cn.wsxter.dao.Impl;

import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.Customer;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


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
}