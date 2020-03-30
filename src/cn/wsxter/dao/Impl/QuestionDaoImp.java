package cn.wsxter.dao.Impl;

import cn.wsxter.dao.QuestionDao;

import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.Question;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImp implements QuestionDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public int findTotalCount(int place_id,String question_name) {
        //String sql = "select count(*) from question where opicId = ?";
        String sql = "select count(*) from question where 1 = 1 ";
        StringBuffer stringBuffer = new StringBuffer(sql);
        List parm = new ArrayList();

        if (place_id != 0)
        {
            stringBuffer.append(" and opicId = ? ");
            parm.add(place_id);
        }
        if (question_name != null&& question_name.length()>0)
        {
            stringBuffer.append(" and question_name like ? ");
            parm.add("%"+question_name+"%");
        }
         sql = stringBuffer.toString();

        return template.queryForObject(sql,Integer.class,parm.toArray());
    }

    @Override
    public List<Question> findByPage(int place_id, int start, int pageSize,String question_name) {
      //  String sql = "select * from question where opicId = ? limit ? , ?";

        String sql = "select * from question where 1 = 1 ";
        StringBuffer stringBuffer = new StringBuffer(sql);
        List parm = new ArrayList();

        if (place_id != 0)
        {
            stringBuffer.append(" and opicId = ? ");
            parm.add(place_id);
        }
        if (question_name != null&& question_name.length()>0)
        {
            stringBuffer.append(" and question_name like ? ");
            parm.add("%"+question_name+"%");
        }
        stringBuffer.append(" limit ? , ? ");
        parm.add(start);
        parm.add(pageSize);
        sql = stringBuffer.toString();




        List<Question> query = template.query(sql, new BeanPropertyRowMapper<Question>(Question.class),parm.toArray());
        System.out.println(query);
        return query;
    }
}




