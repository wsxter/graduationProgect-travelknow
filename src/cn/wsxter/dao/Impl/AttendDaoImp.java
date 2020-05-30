package cn.wsxter.dao.Impl;

import cn.wsxter.dao.AttendDao;
import cn.wsxter.domain.Attendquestion;
import cn.wsxter.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AttendDaoImp implements AttendDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCountbyUserId(Integer user_id) {
        String sql = " select count(*) from attendquestion where user_id = ?";
        return template.queryForObject(sql,Integer.class,user_id);
    }

    @Override
    public List<Attendquestion> findByPageUser(Integer user_id) {
        String sql = " select question_id from attendquestion where user_id = ?";
        return template.query(sql,new BeanPropertyRowMapper<Attendquestion>(Attendquestion.class),user_id);
    }

    @Override
    public Attendquestion attendQuery(int parseInt, Integer user_id) {

        try {
            String sql = " select * from attendquestion where question_id = ? and user_id = ?";
            Attendquestion attendquestion = template.queryForObject(sql, new BeanPropertyRowMapper<Attendquestion>(Attendquestion.class), parseInt, user_id);
            return attendquestion;
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public void attendQues(int parseInt, Integer user_id) {
        String sql = "insert into attendquestion (question_id,user_id) VALUES (? ,?)";
        template.update(sql,parseInt,user_id);
    }

    @Override
    public void delAttend(int parseInt, Integer user_id) {
        String sql = "delete from attendquestion where question_id = ? and user_id = ?";
        template.update(sql,parseInt,user_id);
    }

}
