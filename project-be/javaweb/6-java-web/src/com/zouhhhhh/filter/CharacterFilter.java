package com.zouhhhhh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = { "/*" })
public class CharacterFilter implements Filter {

    public CharacterFilter() {
        System.out.println("通过无参构造创建characterFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
