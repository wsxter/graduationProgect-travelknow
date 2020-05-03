package cn.wsxter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*@WebFilter("/*")*/
public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/home.html")||requestURI.contains("/register.jsp")||requestURI.contains("/user/")||requestURI.contains("/js/")||requestURI.contains("/css/")||requestURI.contains("/image/")||requestURI.contains("/CheckCodeServlet")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            Object loginUser = request.getSession().getAttribute("loginUser");
            if (loginUser != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/home.html").forward(servletRequest,servletResponse);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
