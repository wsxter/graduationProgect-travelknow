package cn.wsxter.web.servlet;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.Question;
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

        //处理
        int place_id = 0;//分类号
        if (palce_idStr != null&&palce_idStr.length() > 0){
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
        PageBean<Question> pageJson =  questionService.pageQuery(place_id, pageSize,currentPage);
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
        String palce_idStr = request.getParameter("place_id");

        //处理
        int place_id = 0;//分类号
        if (palce_idStr != null&&palce_idStr.length() > 0){
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
        AnswerService answerService = new AnswerServiceImp();
        PageBean<Answer> pageJson =  answerService.pageQuery(place_id, pageSize,currentPage);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(pageJson);
        response.getWriter().write(json);
        // Mapper.writeValue(response.getOutputStream(),pageJson);


    }

}
