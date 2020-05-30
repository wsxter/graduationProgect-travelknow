import cn.wsxter.domain.Customer;
import cn.wsxter.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wsxter
 * @create 2020-05-22 15:08
 * @desc
 **/
public class circle {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService  userService = (UserService) applicationContext.getBean("userService");

    }
}
