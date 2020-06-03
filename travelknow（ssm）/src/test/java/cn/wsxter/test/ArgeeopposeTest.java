package cn.wsxter.test;

import cn.wsxter.dao.ArgeeMapper;
import cn.wsxter.domain.Agreeoppose;
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

/**
 * @author wsxter
 * @create 2020-05-19 12:55
 * @desc 测试argeeopppose
 **/
public class ArgeeopposeTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private ArgeeMapper argeeMapper;





    @Before
    public void init() throws IOException {

        in = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        argeeMapper = session.getMapper(ArgeeMapper.class);
        /*questionDao = session.getMapper(QuestionDao.class);*/

    }
    @After
    public void finlly() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void judgment(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("answer_id",64);
        map.put("user_id",8);
        int judgment = argeeMapper.judgment(map);
        System.out.println(judgment);

    }
    @Test
    public  void  addargTest(){
        Agreeoppose agreeoppose = new Agreeoppose();
        agreeoppose.setAnswer_id(64);
        agreeoppose.setUser_id(9);
        argeeMapper.addagree(agreeoppose);
        argeeMapper.commentnum(7);
    }
}
