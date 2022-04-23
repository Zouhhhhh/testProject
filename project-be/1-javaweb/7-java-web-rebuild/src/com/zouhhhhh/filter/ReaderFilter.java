package com.zouhhhhh.filter;

import com.zouhhhhh.bean.Reader;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zouhao
 * @date 2022/4/20
 */
@WebFilter(urlPatterns = {"/book"})
public class ReaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Reader reader = (Reader) session.getAttribute("reader");
        if (reader != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("login.jsp");
        }
    }
}
