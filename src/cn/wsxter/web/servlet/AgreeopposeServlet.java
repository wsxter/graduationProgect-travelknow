package cn.wsxter.web.servlet;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.ResultInfo;
import cn.wsxter.Service.AgreeopposeService;
import cn.wsxter.Service.Impl.AgreeopposeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//p
@WebServlet("/agreeoppose/*")
public class AgreeopposeServlet extends BaseServlet {
    AgreeopposeService as = new AgreeopposeServiceImpl();
    //判断点赞与否
    public void  judgment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        ResultInfo judgment = new ResultInfo();
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");

        String agropp = request.getParameter("agropp");
        String answer_id = request.getParameter("answer_id");

        int i = Integer.parseInt(answer_id);
        int i1 = Integer.parseInt(agropp);
        int user_id = loginUser.getUser_id();
        judgment = as.judgment(i,user_id,i1);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(judgment);
        response.getWriter().write(json);


    }

    public void  loadjudgment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ResultInfo judgment = new ResultInfo();
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");

        String agropp = request.getParameter("agropp");
        String answer_id = request.getParameter("answer_id");

        int i = Integer.parseInt(answer_id);
        int i1 = Integer.parseInt(agropp);
        int user_id = loginUser.getUser_id();
        judgment = as.loadjudgment(i,user_id,i1);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(judgment);
        response.getWriter().write(json);

    }
    public void  comment_num(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        int i = as.comment_num(loginUser.getUser_id());
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(i);
        response.getWriter().write(json);
    }
}
