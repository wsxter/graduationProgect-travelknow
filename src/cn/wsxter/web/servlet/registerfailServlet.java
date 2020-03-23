package cn.wsxter.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerfailServlet")
public class registerfailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //输出
        response.getWriter().write("<div style=\"text-align: center;\"注册失败，返回注册页面");
        try {
            Thread.sleep(1000*3);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/register.jsp");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
