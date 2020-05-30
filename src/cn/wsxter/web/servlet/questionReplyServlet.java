package cn.wsxter.web.servlet;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.Question;
import cn.wsxter.domain.place;
import cn.wsxter.domain.quesreplypageBean;
import cn.wsxter.Service.CategoryService;
import cn.wsxter.Service.Impl.CategoryServiceImp;
import cn.wsxter.Service.Impl.QuestionServiceImp;
import cn.wsxter.Service.Impl.UserServiceImpl;
import cn.wsxter.Service.QuestionService;
import cn.wsxter.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questionReplyServlet/*")
public class questionReplyServlet extends BaseServlet {
    public void questionQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer question_id = new Integer(request.getParameter("question_id"));
        QuestionService questionService = new QuestionServiceImp();
        Question one = questionService.findOne(question_id);
        UserService userService = new UserServiceImpl();
        Customer quesQuery_user = userService.finduserbyid(one.getUser_id());
        CategoryService categoryService = new CategoryServiceImp();
        place place = categoryService.findOne(one.getOpicId());
        quesreplypageBean qrpb = new quesreplypageBean();
        qrpb.setCustomer(quesQuery_user);
        qrpb.setQuestion(one);
        qrpb.setPlace(place);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();

        String json = Mapper.writeValueAsString(qrpb);

        response.getWriter().write(json);



    }


}
