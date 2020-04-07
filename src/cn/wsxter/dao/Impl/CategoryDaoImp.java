package cn.wsxter.dao.Impl;

import cn.wsxter.dao.CategoryDao;
import cn.wsxter.domain.Customer;
import cn.wsxter.domain.place;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Locale;

public class CategoryDaoImp implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<place> findall() {

        String sql = "select * from place";
        return  template.query(sql, new BeanPropertyRowMapper<place>(place.class));
    }

    @Override
    public place findOne(int place_id) {
        String sql = "select place_name from place where place_id = ? ";
        place p = template.queryForObject(sql,new BeanPropertyRowMapper<place>(place.class),place_id);
        return p;

    }

    @Override
    public List<place> inserOne(String place_name) {
        String sql = "insert into place (place_name)  VALUES( ? )";
        template.update(sql,place_name);
        String sql1 = "select place_id from place where place_name = ? ";
        List<place> query = template.query(sql1,new BeanPropertyRowMapper<place>(place.class),place_name);
        return query;

    }
}
