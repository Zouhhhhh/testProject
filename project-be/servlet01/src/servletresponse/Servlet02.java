package servletresponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    字符流
    乱码原因：
        对于getWriter()获取到的字符流，响应中文必定乱码，由于服务器再进行编码时默认会使用ISO-8859-1格式的编码，不支持中文
    乱码解决：
        1. 设置服务器编码格式
        2. 设置客户端编码格式

 */
@WebServlet("/resp02")
public class Servlet02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置服务端的编码格式
        resp.setCharacterEncoding("UTF-8");

        //设置客户端的编码格式
        resp.setHeader("content-type","text/html;charset=UTF-8");

        //同时设置
//        resp.setContentType("text/html;charset=UTF-8");

        //获取字符输出流
        PrintWriter writer = resp.getWriter();
        //输出数据
        writer.write("<h2>你好</h2>");

    }
}
