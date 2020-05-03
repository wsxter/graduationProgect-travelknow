package cn.wsxter.web.servlet;

import cn.wsxter.domain.Recommend;
import cn.wsxter.service.Impl.RecommendServiceImpl;
import cn.wsxter.service.RecommendService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/recommend/*")
public class RecommendServlet extends BaseServlet {
    public void recommendQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("current_Page");
        int currentPage = 0;//当前页码
        if (currentPageStr != null&&currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        int pageSize = 5;

        RecommendService recommendService = new RecommendServiceImpl();
        List list = recommendService.res_Query(pageSize,currentPage);
        list.removeAll(Collections.singleton(null));

        System.out.println(list);

        response.setContentType("application/json;charset=utf-8");

        ObjectMapper Mapper = new ObjectMapper();
        String json = Mapper.writeValueAsString(list);
        response.getWriter().write(json);


    }

}
