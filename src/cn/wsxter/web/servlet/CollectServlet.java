package cn.wsxter.web.servlet;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.ResultInfo;
import cn.wsxter.Service.CollectService;
import cn.wsxter.Service.Impl.CollectServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/collect/*")
public class CollectServlet extends BaseServlet {
    public void addcollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String answer_id = request.getParameter("answer_id");
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        CollectService collectService = new CollectServiceImp();
        ResultInfo collect = collectService.findCollect(Integer.parseInt(answer_id), loginUser.getUser_id());
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(collect);
        response.getWriter().write(json);

    }
    public void loadaddcollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String answer_id = request.getParameter("answer_id");
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        CollectService collectService = new CollectServiceImp();
        ResultInfo collect = collectService.loadfindCollect(Integer.parseInt(answer_id), loginUser.getUser_id());
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(collect);
        response.getWriter().write(json);

    }
    public void collect_num(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        CollectService collectService = new CollectServiceImp();
        int i = collectService.collect_num(loginUser.getUser_id());
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(i);
        response.getWriter().write(json);
    }


}
