package cn.wsxter.controller;

import cn.wsxter.domain.Customer;
import cn.wsxter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wsxter
 * @create 2020-05-22 18:23
 * @desc 用户控制层
 **/
@Controller
@RequestMapping("/user123")
public class UserController {
    @Autowired
    private UserService userService;
    /*
     * @Description //TODO 添加用户
     * @Param [customer]
     * @return java.lang.String
     **/
    @RequestMapping("/adduser.do")
    public ModelAndView addUser(Customer customer){
        System.out.println(customer);
        customer.setEmail("9876@321.com");
        userService.addUser(customer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("user",customer);

        return modelAndView;
    }
}
