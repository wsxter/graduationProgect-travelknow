package cn.wsxter.test;


import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.Customer;
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

public class uesrtest {


        private InputStream in;
        private SqlSessionFactory factory;
        private SqlSession session;
        private  UserDao customerDao;




        @Before
        public void init() throws IOException {

            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
            session = factory.openSession();
            customerDao = session.getMapper(UserDao.class);
            /*questionDao = session.getMapper(QuestionDao.class);*/

        }
        @After
        public void finlly() throws IOException {
            session.commit();
            session.close();
            in.close();
        }
/*    @Test
    public void custom(){
        Question customers = questionDao.findbyquesId(3);

        System.out.println(customers);
        System.out.println(customers.getCustomer());

    }*/
@Test
public void findall(){
    Customer customer = new Customer();
    customer.setUser_id(7);
    Customer customers = customerDao.finduser(customer);
    System.out.println(customers);

}
@Test
public void addUserTest(){
    Customer customer = new Customer();
    customer.setUsername("天天向上");
    customer.setPassword("1234");
    customer.setEmail("1234@qq.com");
    customerDao.addUser(customer);
}
@Test
public void findTotalCountTest(){
    int totalCount = customerDao.findTotalCount();
    System.out.println(totalCount);

}
@Test
public  void  findbypageTest(){
    HashMap<String,Object> map = new HashMap<>();

    map.put("username","wsxter1");
    List<Customer> customers = customerDao.findByPage(map);
    for (Customer customer : customers) {
        System.out.println(customer);
    }
}
@Test
public  void  deluserTest(){
    customerDao.deluser(7);
}
@Test
public  void  gooduserTest(){

    customerDao.gooduser(7);
}
@Test
public  void  updateTest(){

    Customer customer = new Customer();
    customer.setUser_id(7);
    customer.setEmail("1");
    customer.setPassword("123");
    customer.setRole(1);
    customer.setAutograph("加油");
    customer.setUsername("wsxter1");
    customerDao.update(customer);
}












}






