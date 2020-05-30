package cn.wsxter.dao.Impl;

import cn.wsxter.dao.CollectDao;
import cn.wsxter.domain.Collect;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CollectDaoImp implements CollectDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findCollect(int parseInt, Integer user_id) {
        String sql = "select count(*) from collect where answer_id = ? and user_id = ? ";
        return template.queryForObject(sql,Integer.class,parseInt,user_id);
    }

    @Override
    public void addCollect(String answer_content, String question_name, Integer user_id ,int parseInt) {
        String sql = "insert into collect (answer_id,user_id,question_name,answer_content) VALUES ( ?, ?, ? ,?)";
        template.update(sql,parseInt,user_id,question_name,answer_content);
    }

    @Override
    public int collect_num(Integer user_id) {
        String sql = " select count(*) from collect where user_id = ?";
        return template.queryForObject(sql,Integer.class,user_id);
    }

    @Override
    public List<Collect> findByPageUser(Integer user_id, int start, int pageSize) {
        String sql = "select * from collect where user_id = ? limit ? , ? ";
        List<Collect> query = template.query(sql, new BeanPropertyRowMapper<Collect>(Collect.class),user_id,start,pageSize);
        return query;
    }


}
