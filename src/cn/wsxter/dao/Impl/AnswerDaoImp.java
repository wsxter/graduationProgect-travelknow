package cn.wsxter.dao.Impl;

import cn.wsxter.dao.AnswerDao;
import cn.wsxter.domain.Answer;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AnswerDaoImp implements AnswerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int place_id) {
        String sql = "select count(*) from question where opicId = ?";
        return template.queryForObject(sql,Integer.class,place_id);
    }

    @Override
    public List<Answer> findByPage(int place_id, int start, int pageSize) {
        String sql = "select * from question where opicId = ? limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<Answer>(Answer.class),place_id,start,pageSize);
    }
}
