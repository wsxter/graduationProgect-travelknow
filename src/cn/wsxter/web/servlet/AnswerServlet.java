package cn.wsxter.web.servlet;

import cn.wsxter.domain.*;
import cn.wsxter.Service.AnswerService;
import cn.wsxter.Service.CategoryService;
import cn.wsxter.Service.FAService;
import cn.wsxter.Service.Impl.AnswerServiceImp;
import cn.wsxter.Service.Impl.CategoryServiceImp;
import cn.wsxter.Service.Impl.FAServiceImp;
import cn.wsxter.Service.Impl.QuestionServiceImp;
import cn.wsxter.Service.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answer/*")
public class AnswerServlet extends BaseServlet {
    QuestionService questionService = new QuestionServiceImp();
    CategoryService categoryService = new CategoryServiceImp();
    public void submit_answer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String content = request.getParameter("content");
        String questionId = request.getParameter("question_id");
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
      /*  falseanswer answer = new falseanswer();*/
        falseanswer falseanswer = new falseanswer();
        falseanswer.setUser_id(loginUser.getUser_id());
        String name = "";

        if (questionId!= null&&questionId.length() > 0){
             int i = Integer.parseInt(questionId);
            Question one = questionService.findOne(i);
            name = one.getQuestion_name();
            falseanswer.setQues_describle(one.getQues_describle());
            place one1 = categoryService.findOne(one.getOpicId());
            falseanswer.setPlace_name(one1.getPlace_name());
        }else {
            name = request.getParameter("question_name");
            String place_name = request.getParameter("place_name");
            falseanswer.setPlace_name(place_name);
            String ques_decrible = request.getParameter("ques_decrible");
            falseanswer.setQues_describle(ques_decrible);
        }


        falseanswer.setQues_name(name);
        falseanswer.setAnswer_content(content);
        FAService faService = new FAServiceImp();
        faService.addAnswer(falseanswer);
        ResultInfo resultInfo = new ResultInfo();
        response.setContentType("application/json;charset=utf-8");
        resultInfo.setFlag(true);
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(resultInfo);
        response.getWriter().write(json);


    }
    //找answer，返回一个answer对象
    public void findbyAnswerId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer_id = request.getParameter("answer_id");
        AnswerService answerService = new AnswerServiceImp();
        Answer answer = answerService.finbyAnswerId(Integer.parseInt(answer_id));
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(answer);
        response.getWriter().write(json);
    }
    public void addcomment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer_id = request.getParameter("answer_id");
        AnswerService answerService = new AnswerServiceImp();
        int comment = answerService.addComment(Integer.parseInt(answer_id));
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(comment);
        response.getWriter().write(json);

    }


}
