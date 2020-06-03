package cn.wsxter.test;

import cn.wsxter.dao.AttendMapper;
import cn.wsxter.domain.Attendquestion;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author wsxter
 * @create 2020-05-19 14:10
 * @desc 测试AttendDao
 **/
public class AttendTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AttendMapper attendMapper;




    @Before
    public void init() throws IOException {

        in = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        attendMapper = session.getMapper(AttendMapper.class);
        /*questionDao = session.getMapper(QuestionDao.class);*/

    }
    @After
    public void finlly() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void findByPageUserTest(){
        int i = 7;
        List<Attendquestion> attendquestions = attendMapper.findByPageUser(7);
        for (Attendquestion attendquestion : attendquestions) {
            System.out.println(attendquestion);
        }
    }
    @Test
    public void attendQueryTest(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("question_id",66);
        map.put("user_id",7);
        Attendquestion attendquestion = attendMapper.attendQuery(map);
        System.out.println(attendquestion);
    }
    @Test
    public void attendques(){
        Attendquestion attendquestion = new Attendquestion();
        attendquestion.setUser_id(13);
        attendquestion.setQuestion_id(100);
        attendMapper.attendQues(attendquestion);

    }
    @Test
    public void delques(){
        Attendquestion attendquestion = new Attendquestion();
        attendquestion.setUser_id(13);
        attendquestion.setQuestion_id(100);
        attendMapper.delAttend(attendquestion);

    }

}
