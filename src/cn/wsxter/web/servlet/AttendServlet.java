package cn.wsxter.web.servlet;

import cn.wsxter.domain.Attendquestion;
import cn.wsxter.domain.Customer;
import cn.wsxter.domain.ResultInfo;
import cn.wsxter.service.AttendService;
import cn.wsxter.service.Impl.AttendServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/attend/*")
public class AttendServlet extends BaseServlet {
    public void attendques(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo re = new ResultInfo();
        String questionId = request.getParameter("question_id");
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        AttendService attendService = new AttendServiceImp();
        Attendquestion attendquestion = attendService.attengQuery(Integer.parseInt(questionId), loginUser.getUser_id());
        if (attendquestion == null){
            attendService.attendQues(Integer.parseInt(questionId),loginUser.getUser_id());
            re.setFlag(true);
        }else {
            attendService.delAttend(Integer.parseInt(questionId),loginUser.getUser_id());
            re.setFlag(false);
        }


        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(re);
        response.getWriter().write(json);

    }
    public void attendQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo re = new ResultInfo();
        String questionId = request.getParameter("question_id");
        Customer loginUser = (Customer) request.getSession().getAttribute("loginUser");
        AttendService attendService = new AttendServiceImp();
        Attendquestion attendquestion = attendService.attengQuery(Integer.parseInt(questionId), loginUser.getUser_id());
        if (attendquestion == null) {
            re.setFlag(false);
        }else {

            re.setFlag(true);
        }
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(re);
        response.getWriter().write(json);
    }
}
