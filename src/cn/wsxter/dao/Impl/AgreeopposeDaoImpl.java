package cn.wsxter.dao.Impl;

import cn.wsxter.dao.ArgeeopposeDao;
import cn.wsxter.domain.Agreeoppose;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class AgreeopposeDaoImpl implements ArgeeopposeDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int judgment(int parseInt,int user_id) {
        String sql = "select count(*) from agreeoppose where answer_id = ? and user_id = ? ";
        return template.queryForObject(sql,Integer.class,parseInt,user_id);
    }

    @Override
    public void addarg(int parseInt, int user_id, int agropp) {
        String sql = "insert into agreeoppose (answer_id,user_id,argopp) VALUES ( ?, ?, ?)";
        template.update(sql,parseInt,user_id,agropp);
    }

    @Override
    public int comment_num(int parseInt) {
        String sql = " select count(*) from agreeoppose where user_id = ?";
        return template.queryForObject(sql,Integer.class,parseInt);
    }
}
