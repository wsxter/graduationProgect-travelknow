package cn.wsxter.dao.Impl;

import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.User;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import cn.wsxter.dao.UserDao;
        import cn.wsxter.domain.User;
        import cn.wsxter.util.JDBCUtils;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values (null,?,?,?)";
        template.update(sql,  user.getUsername(), user.getPassword(),user.getEmail());
    }
}