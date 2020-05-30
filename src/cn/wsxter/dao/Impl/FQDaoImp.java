package cn.wsxter.dao.Impl;

import cn.wsxter.dao.FQDao;
import cn.wsxter.domain.falseques;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FQDaoImp implements FQDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount() {
        String sql = "select count(*) from falseques";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<falseques> findByPage(int start, int pageSize) {
        String sql = "select * from falseques limit ? , ? ";

        List<falseques> query = template.query(sql, new BeanPropertyRowMapper<falseques>(falseques.class),start,pageSize);
        return query;
    }

    @Override
    public void delques(int parseInt) {
        String sql = "delete from falseques where ques_id = ? ";
        template.update(sql,parseInt);
    }

    @Override
    public falseques findbyid(int ques_id) {
        String sql = "select * from falseques where ques_id = ? ";

        falseques query = template.queryForObject(sql, new BeanPropertyRowMapper<falseques>(falseques.class),ques_id);
        return  query;
    }

    @Override
    public void userAddQues(falseques falseques) {
        String sql = "insert into falseques(user_id,ques_name,ques_describle,place_name) VALUES (?,?,?,?)";
        template.update(sql,falseques.getUser_id(),falseques.getQues_name(),falseques.getQues_describle(),falseques.getPlace_name());
    }
}
