package cn.wsxter.web.servlet;

import cn.wsxter.domain.place;
import cn.wsxter.service.CategoryService;
import cn.wsxter.service.Impl.CategoryServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class categoryServlet<list> extends BaseServlet {
    public void  findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryServiceImp = new CategoryServiceImp();
        List<place> all = categoryServiceImp.findAll();
        ObjectMapper Mapper = new ObjectMapper();
        response.setContentType("application/json;charset:utf-8");
        Mapper.writeValue(response.getOutputStream(),all);


    }


}
