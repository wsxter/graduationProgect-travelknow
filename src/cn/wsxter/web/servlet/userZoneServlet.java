package cn.wsxter.web.servlet;

import cn.wsxter.domain.Customer;
import cn.wsxter.domain.PageBean;
import cn.wsxter.service.Impl.userZoneServiceImp;
import cn.wsxter.service.userZoneService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userZone/*")
public class userZoneServlet extends BaseServlet {
    public void   userZoneQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer loginUser =(Customer) request.getSession().getAttribute("loginUser");
        String currentPageStr = request.getParameter("current_Page");
        String pageSizeStr = request.getParameter("pageSize");
        String buttonCategory = request.getParameter("buttonCategory");
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
        //userid 1,2,3,4/问题、回答、关注、收藏
        userZoneService userZoneService = new userZoneServiceImp();
        PageBean pageBean = userZoneService.userZoneQuery(loginUser.getUser_id(), currentPage, pageSize, Integer.parseInt(buttonCategory));
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(pageBean);
        response.getWriter().write(json);


    }
}
