package cn.wsxter.dao;

import cn.wsxter.domain.User;
import cn.wsxter.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//操作数据库中User表中的类
public interface UserDao {
    User findUserByUsernameAndPassword(String username, String password);
    void addUser(User user);


}
