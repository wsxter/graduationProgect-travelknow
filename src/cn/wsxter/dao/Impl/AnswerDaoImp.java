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
    public int findTotalCount(int question_id) {
        String sql = "select count(*) from answer where question_id = ?";
        return template.queryForObject(sql,Integer.class,question_id);
    }

    @Override
    public List<Answer> findByPage(int question_id, int start, int pageSize) {
        String sql = "select * from answer where question_id = ? limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<Answer>(Answer.class),question_id,start,pageSize);
    }

    @Override
    public List<Answer> findNewest(int start, int pageSize) {
        String sql = "select * from question order by create_time desc limit ? , ? ";

        List<Answer> query = template.query(sql, new BeanPropertyRowMapper<Answer>(Answer.class),start,pageSize);
        return query;
    }

    @Override
    public void updateAnswer(Answer answer) {
        String sql = "insert into answer (user_id,question_id,answer_content) VALUES (?,?,?)";
        template.update(sql,answer.getUser_id(),answer.getQuestion_id(),answer.getAnswer_content());
    }

    @Override
    public Answer answer_query(int answer_id) {
        String sql = " select * from answer where answer_id = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Answer>(Answer.class),answer_id);
    }
}
