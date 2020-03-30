package cn.wsxter.dao.Impl;

import cn.wsxter.dao.QuestionDao;

import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.Question;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestionDaoImp implements QuestionDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public int findTotalCount(int place_id) {
        String sql = "select count(*) from question where opicId = ?";
        return template.queryForObject(sql,Integer.class,place_id);
    }

    @Override
    public List<Question> findByPage(int place_id, int start, int pageSize) {
        String sql = "select * from question where opicId = ? limit ? , ?";
        List<Question> query = template.query(sql, new BeanPropertyRowMapper<Question>(Question.class),place_id,start,pageSize);
        System.out.println(query);
        return query;
    }
}




