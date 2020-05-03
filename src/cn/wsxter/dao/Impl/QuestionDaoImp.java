package cn.wsxter.dao.Impl;

import cn.wsxter.dao.QuestionDao;

import cn.wsxter.domain.Question;
import cn.wsxter.util.JDBCUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.dao.DataAccessException;
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
        if (question_name != null&& question_name.length()>0&&!"null".equals(question_name))
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
        if (question_name != null&& question_name.length()>0&&!"null".equals(question_name))
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

    @Override
    public List<Question> findNewest(int start, int pageSize) {
        String sql = "select * from question order by create_time desc limit ? , ? ";

        List<Question> query = template.query(sql, new BeanPropertyRowMapper<Question>(Question.class),start,pageSize);
        return query;
    }
    public int totalcount(){
        String sql = "select count(*) from question";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public Question findOne(int question_id) {
        String sql = "select * from question where question_id = ? ";
        Question question = template.queryForObject(sql, new BeanPropertyRowMapper<Question>(Question.class), question_id);
        return question;
    }

    @Override
    public List<Question> find_hot() {
        String sql = "select * from question order by answer_num desc limit 0 , 4 ";
        List<Question> query = template.query(sql, new BeanPropertyRowMapper<Question>(Question.class));
        return query;

    }

    @Override
    public void addques(String ques_name, String ques_describle, Integer place_id, Integer user_id) {
        String sql = "insert into question (question_name,user_id,ques_describle,opicId) VALUES (?,?,?,?)";
        template.update(sql,ques_name,user_id,ques_describle,place_id);
    }

    @Override
    public Question findbyname(String ques_name,int opicId) {
        try {
            String sql ="select * from question where question_name = ? and opicId = ? limit 0,1";

            Question question = template.queryForObject(sql, new BeanPropertyRowMapper<Question>(Question.class), ques_name,opicId);
            return question;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int findTotalCountbyUserId(Integer user_id) {
        String sql = "select count(*) from question where user_id = ? ";
        return template.queryForObject(sql,Integer.class,user_id);
    }

    @Override
    public List<Question> findByPageUser(Integer user_id, int start, int pageSize) {
        String sql = "select * from question where user_id = ? limit ? , ? ";

        List<Question> query = template.query(sql, new BeanPropertyRowMapper<Question>(Question.class),user_id,start,pageSize);
        return query;
    }

    @Override
    public List<Question> findlikename(String question_name) {
        String sql = "select * from question where question_name like ? order by create_time limit 0,8";
        List<Question> query = template.query(sql, new BeanPropertyRowMapper<Question>(Question.class), "%"+question_name+"%");
        return  query;
    }

}




