package cn.wsxter.dao.Impl;

import cn.wsxter.dao.RecommendDao;
import cn.wsxter.domain.Recommend;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RecommendDaoImpl implements RecommendDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Recommend> rec_list(int Star, int Page_Size) {
        String sql ="select * from recommend order by create_time desc limit ? , ?  ";
       return template.query(sql,new BeanPropertyRowMapper<Recommend>(Recommend.class),Star,Page_Size);
    }


}
