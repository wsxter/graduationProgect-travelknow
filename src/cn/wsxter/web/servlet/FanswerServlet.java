package cn.wsxter.web.servlet;

import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.falseanswer;
import cn.wsxter.Service.FAService;
import cn.wsxter.Service.Impl.FAServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fanswer/*")
public class FanswerServlet extends BaseServlet {
    private FAService faService = new FAServiceImp();
    public void findanswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            pageSize = 1;
        }
        PageBean<falseanswer> ques = faService.findAnswer(currentPage, pageSize);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(ques);
        response.getWriter().write(json);
    }
    public void delanswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer_id = request.getParameter("answer_id");
        FAService faService = new FAServiceImp();
        faService.delanswer(answer_id);
    }
    public void addanswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer_id = request.getParameter("answer_id");
        faService.addAnswertrue(answer_id);

    }


}
