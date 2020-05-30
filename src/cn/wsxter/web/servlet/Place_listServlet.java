package cn.wsxter.web.servlet;

import cn.wsxter.domain.*;

import cn.wsxter.Service.Impl.AnswerServiceImp;
import cn.wsxter.Service.AnswerService;

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
import java.util.List;


@WebServlet("/place_list/*")
public class Place_listServlet extends BaseServlet {

    //分页查询
    public void quesPageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受
        String currentPageStr = request.getParameter("current_Page");
        String pageSizeStr = request.getParameter("pageSize");
        String palce_idStr = request.getParameter("place_id");
        String question_name = request.getParameter("question_name");

        //处理
        int place_id = 0;//分类号
        if (palce_idStr != null&&palce_idStr.length() > 0&& !"null".equals(palce_idStr)){
           place_id = Integer.parseInt(palce_idStr);
        }
        int currentPage = 0;//当前页码
        if (currentPageStr != null&&currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        int pageSize = 0;//每页显示条数
        if (pageSizeStr != null&&pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else {
            pageSize = 5;
        }


        QuestionService questionService = new QuestionServiceImp();
        PageBean<Question> pageJson =  questionService.pageQuery(place_id, pageSize,currentPage,question_name);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
       String json = Mapper.writeValueAsString(pageJson);
        response.getWriter().write(json);
       // Mapper.writeValue(response.getOutputStream(),pageJson);


    }
    public void answerPageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受
        String currentPageStr = request.getParameter("current_Page");
        String pageSizeStr = request.getParameter("pageSize");
        String question_idStr = request.getParameter("question_id");

        //处理
        int question_id = 0;//问题号
        if (question_idStr != null&&question_idStr.length() > 0){
            question_id = Integer.parseInt(question_idStr);
        }
        int currentPage = 0;//当前页码
        if (currentPageStr != null&&currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        int pageSize = 0;//每页显示条数
        if (pageSizeStr != null&&pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else {
            pageSize = 5;
        }
        AnswerService answerService = new AnswerServiceImp();
        PageBean<Answer> pageJson =  answerService.pageQuery(question_id, pageSize,currentPage);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(pageJson);
        response.getWriter().write(json);
        // Mapper.writeValue(response.getOutputStream(),pageJson);


    }

    public void newestPageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        int currentPage = 0;//当前页码
        if (currentPageStr != null&&currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        int pageSize = 5;


    }
    public void quesfindone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String questionId = request.getParameter("question_id");
        QuestionService questionService = new QuestionServiceImp();
        Question one = questionService.findOne(Integer.parseInt(questionId));
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(one);
        response.getWriter().write(json);

    }
    public void find_hot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionService questionService = new QuestionServiceImp();
        List<Question> hot = questionService.find_hot();
        ObjectMapper Mapper = new ObjectMapper();
        response.setContentType("application/json;charset:utf-8");
        Mapper.writeValue(response.getOutputStream(),hot);

    }



    //管理员对用户的查找
    public void userPageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受
        String currentPageStr = request.getParameter("current_Page");
        String pageSizeStr = request.getParameter("pageSize");

        int currentPage = 0;//当前页码
        if (currentPageStr != null&&currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        int pageSize = 0;//每页显示条数
        if (pageSizeStr != null&&pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else {
            pageSize = 10;
        }


        UserService userService = new UserServiceImpl();
        PageBean<Customer> pageJson =  userService.pageQuery(pageSize,currentPage);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(pageJson);
        response.getWriter().write(json);
        // Mapper.writeValue(response.getOutputStream(),pageJson);


    }
    public void findlikename(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String question_name = request.getParameter("question_name");
        QuestionService questionService = new QuestionServiceImp();
        PageBean<Question> findbyname = questionService.findbyname(question_name);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(findbyname);
        response.getWriter().write(json);
    }

}
