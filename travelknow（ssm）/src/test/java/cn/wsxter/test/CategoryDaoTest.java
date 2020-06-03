package cn.wsxter.test;

import cn.wsxter.dao.CategoryDao;
import cn.wsxter.domain.place;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wsxter
 * @create 2020-05-19 14:25
 * @desc 测试CategoryDao
 **/
public class CategoryDaoTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private CategoryDao categoryDao;




    @Before
    public void init() throws IOException {

        in = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        categoryDao = session.getMapper(CategoryDao.class);
        /*questionDao = session.getMapper(QuestionDao.class);*/

    }
    @After
    public void finlly() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void findallTest(){
        List<place> places = categoryDao.findall();
        for (place place : places) {
            System.out.println(place);
        }
    }
    @Test
    public void findbyTest(){
        place place = new place();
        place.setPlace_name("泰山");
        cn.wsxter.domain.place findby = categoryDao.findby(place);
        System.out.println(findby);
    }
    @Test
    public void insertOne(){
        place place = new place();
        place.setPlace_name("火星");
        categoryDao.inserOne(place);
        System.out.println(place);
    }
}
