package cn.wsxter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(urlPatterns = {"/userzone.html","/write_answer.html","/admin.html"},servletNames = {"/fques/*","/fanswer/*","/collect/*","/attend/*"})
public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

       HttpServletRequest request = (HttpServletRequest) servletRequest;
        /* String requestURI = request.getRequestURI();
        if (requestURI.contains("/.html")||requestURI.contains("/register.jsp")||
                requestURI.contains("/user/")||
                requestURI.contains("/js/")||
                requestURI.contains("/css/")||
                requestURI.contains("/image/")||
                requestURI.contains("/checkCodeServlet")||
                requestURI.contains("/place_list/")||
                requestURI.contains("/questionReplyServlet/")||
                requestURI.contains("/BaseServlet")||
                requestURI.contains("/recommend/")||
                requestURI.contains("/answer/")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {*/
            Object loginUser = request.getSession().getAttribute("loginUser");
            if (loginUser != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/errormsg.html").forward(servletRequest,servletResponse);
            }


    }

    @Override
    public void destroy() {

    }
}
