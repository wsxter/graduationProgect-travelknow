package cn.wsxter.web.servlet;

import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.User;
import cn.wsxter.service.Impl.UserServiceImpl;
import cn.wsxter.service.UserService;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        Map<String, String[]> map = req.getParameterMap();
        //封装user对象
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //创建service层对象
        UserService service = new UserServiceImpl();
        User user = service.login(loginUser);
        //判断user
        if (user == null){
            //登录失败，转发failservlet
            req.getRequestDispatcher("/failServlet").forward(req,resp);

        }else {
            //登录成功，存储数据、转发
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
