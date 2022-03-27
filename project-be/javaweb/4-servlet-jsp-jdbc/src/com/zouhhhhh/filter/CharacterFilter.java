package com.zouhhhhh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@WebFilter("/*")
public class CharacterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
//        servletResponse.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
//        servletResponse.setHeader("Content-Type", "text/html;charset=utf-8");    //通知浏览器使用utf-8解码

        servletResponse.setContentType("text/html;charset=utf-8");    //包含第一种方式的两个功能
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
