package com.zouhhhhh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/word")
public class WordFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将“敏感词”换成**
        String name = servletRequest.getParameter("name");
        System.out.println(name);
        name = name.replaceAll("敏感词", "***");
        servletRequest.setAttribute("name", name);
        System.out.println(name);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
