package cn.wsxter.web.servlet;

import cn.wsxter.domain.*;

import cn.wsxter.service.Impl.AnswerServiceImp;
import cn.wsxter.service.AnswerService;

import cn.wsxter.service.Impl.QuestionServiceImp;
import cn.wsxter.service.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


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
        String currentPageStr = request.getParameter("currentPage");
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


    }

}
