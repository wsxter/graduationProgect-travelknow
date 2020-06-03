package cn.wsxter.test;

import cn.wsxter.dao.FQDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wsxter
 * @create 2020-05-19 14:57
 * @desc 测试FQDao
 **/
public class FQDaoTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private FQDao fqDao;




    @Before
    public void init() throws IOException {

        in = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        fqDao = session.getMapper(FQDao.class);
        /*questionDao = session.getMapper(QuestionDao.class);*/

    }
    @After
    public void finlly() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void findTotalCount(){
        int totalCount = fqDao.findTotalCount();
        System.out.println(totalCount);
    }
}
