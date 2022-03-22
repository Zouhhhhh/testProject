package com.zouhhhhh.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("通过无参构造创建MyFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destroy...");
    }
}
