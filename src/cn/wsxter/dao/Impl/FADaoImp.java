package cn.wsxter.dao.Impl;

import cn.wsxter.dao.FADao;
import cn.wsxter.domain.falseanswer;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FADaoImp implements FADao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void addAnswer(falseanswer answer) {
        if (answer.getPlace_name() !=null) {
            String sql = "insert into falseanswer (answer_id,user_id,ques_name,answer_content,place_name,ques_describle) VALUES (?,?,?,?,?,?)";
            template.update(sql, answer.getAnswer_id(), answer.getUser_id(), answer.getQues_name(), answer.getAnswer_content(), answer.getPlace_name(), answer.getQues_describle());
        }else {
            String sql = "insert into falseanswer (answer_id,user_id,ques_name,answer_content) VALUES (?,?,?,?)";
            template.update(sql, answer.getAnswer_id(), answer.getUser_id(), answer.getQues_name(), answer.getAnswer_content());
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from falseanswer";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<falseanswer> findByPage(int start, int pageSize) {
        String sql = "select * from falseanswer limit ? , ? ";

        List<falseanswer> query = template.query(sql, new BeanPropertyRowMapper<falseanswer>(falseanswer.class),start,pageSize);
        return query;
    }

    @Override
    public void delAanswer(String answer_id) {
        String sql = "delete from falseanswer where answer_id = ? ";
        template.update(sql,answer_id);
    }

    @Override
    public falseanswer findbyid(String answer_id) {
        String sql = "select * from falseanswer where answer_id= ? ";
        falseanswer query = template.queryForObject(sql, new BeanPropertyRowMapper<falseanswer>(falseanswer.class), Integer.parseInt(answer_id));
        return query;
    }
}
