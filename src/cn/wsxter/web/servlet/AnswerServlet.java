package cn.wsxter.web.servlet;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.Customer;
import cn.wsxter.domain.ResultInfo;
import cn.wsxter.service.AnswerService;
import cn.wsxter.service.Impl.AnswerServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answerServlet")
public class AnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String content = request.getParameter("content");
        String questionId = request.getParameter("question_id");
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        Answer answer = new Answer();
        answer.setUser_id(loginUser.getUser_id());
        int i = Integer.parseInt(questionId);
        answer.setQuestion_id(i);
        answer.setAnswer_content(content);
        AnswerService answerService = new AnswerServiceImp();
        answerService.addAnswer(answer);
        ResultInfo resultInfo = new ResultInfo();
        response.setContentType("application/json;charset=utf-8");
        resultInfo.setFlag(true);
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(resultInfo);
        response.getWriter().write(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
