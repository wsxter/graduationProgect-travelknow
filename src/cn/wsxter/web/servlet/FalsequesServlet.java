package cn.wsxter.web.servlet;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.falseques;
import cn.wsxter.service.FQService;
import cn.wsxter.service.Impl.FQServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fques/*")
public class FalsequesServlet extends BaseServlet {
    FQService fqService = new FQServiceImp();
    //管理员获取问题
    public void findques(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        PageBean<falseques> ques = fqService.findQues(currentPage, pageSize);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(ques);
        response.getWriter().write(json);
    }
    //审核不通过
    public void delques(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ques_id = request.getParameter("ques_id");
        fqService.delques(Integer.parseInt(ques_id));
    }
    //审核通过
    public void addques(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ques_id = request.getParameter("ques_id");
        fqService.addques(Integer.parseInt(ques_id));
    }

    public void  uesraddques(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        falseques falseques = new falseques();
        String place_name = request.getParameter("place_name");
        String question_name = request.getParameter("question_name");
        String content = request.getParameter("content");
        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        falseques.setPlace_name(place_name);
        falseques.setQues_describle(content);
        falseques.setQues_name(question_name);
        falseques.setUser_id(loginUser.getUser_id());
        FQService fqService = new FQServiceImp();
        fqService.userAddQues(falseques);


    }

}
