package cn.wsxter.web.servlet;

import cn.wsxter.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getAttribute("user");
        if (user != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功"+user.getUsername()+",欢迎您,即将跳转到首页");
        }
        String contextPath = request.getContextPath();


        response.sendRedirect(contextPath+"/home.html");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
