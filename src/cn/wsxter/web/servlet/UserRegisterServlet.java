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

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        ResultInfo resultInfo = new ResultInfo();
        ObjectMapper Mapper = new ObjectMapper();
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
        UserService service = new UserServiceImpl();
         boolean flag = service.addUser(user);

        if(flag){
            resultInfo.setFlag(true);
         }
         else {
             resultInfo.setFlag(false);
             resultInfo.setErrorMsg("注册失败，用户名重复");

         }

        String json = Mapper.writeValueAsString(resultInfo);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }
}
