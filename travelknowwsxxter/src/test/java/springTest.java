import cn.wsxter.domain.Customer;
import cn.wsxter.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wsxter
 * @create 2020-05-30 16:30
 * @desc
 **/
public class springTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        Customer customer = new Customer();
        customer.setPassword("12345");
        customer.setUsername("xiaofian");
        customer.setEmail("9876@321.com");
        userService.addUser(customer);

    }
}
