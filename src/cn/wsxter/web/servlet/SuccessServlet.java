package cn.wsxter.web.servlet;

import cn.wsxter.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer = (Customer) request.getAttribute("user");
        if (customer != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功"+customer.getUsername()+",欢迎您,即将跳转到首页");
        }
        String contextPath = request.getContextPath();


        response.sendRedirect(contextPath+"/index.html");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
