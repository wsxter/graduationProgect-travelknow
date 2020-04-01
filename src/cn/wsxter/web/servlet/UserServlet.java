package cn.wsxter.web.servlet;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.ResultInfo;
import cn.wsxter.service.Impl.UserServiceImpl;
import cn.wsxter.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 *
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private  UserService service = new UserServiceImpl();
    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //设置编码
        request.setCharacterEncoding("utf-8");
        ResultInfo resultInfo = new ResultInfo();
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);

        Map<String, String[]> map = request.getParameterMap();
        //封装user对象
        Customer loginUser = new Customer();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //创建service层对象

        Customer user = service.login(loginUser);
        //判断user
        if (user == null){
            //登录失败，转发failservlet
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码错误");

        }else {
            //登录成功，存储数据、转发
            resultInfo.setFlag(true);
            request.getSession().setAttribute("loginUser",user);

        }
        ObjectMapper Mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        Mapper.writeValue(response.getOutputStream(),resultInfo);


    }


    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //设置编码
        ResultInfo resultInfo = new ResultInfo();
        request.setCharacterEncoding("utf-8");

        //获取验证码信息
        String verifycode = request.getParameter("verifycode");
        //校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败，验证码错误");
            ObjectMapper Mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            String json = Mapper.writeValueAsString(resultInfo);
            response.getWriter().write(json);

            return;
        }
        //获取用户注册信息
        Map<String, String[]> map = request.getParameterMap();
        //封装user对象
        Customer user = new Customer();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service层进行查询
        boolean flag = service.addUser(user);
        if(flag){
            resultInfo.setFlag(true);
        }
        else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败，用户名重复");

        }
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(resultInfo);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
    //从session获取到登录的用户，返回对应的用户名给前端
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        ResultInfo resultInfo = new ResultInfo();
        if (loginUser == null) {
            //未登录：flag==false
            resultInfo.setFlag(false);
        }else{
            //已登录：falg==true
            resultInfo.setFlag(true);
            resultInfo.setData(loginUser.getUsername());
        }
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(resultInfo);
        response.getWriter().write(json);

    }
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession().invalidate();//销毁session
        response.sendRedirect(request.getContextPath()+"/home.html");//重定向
    }
}
