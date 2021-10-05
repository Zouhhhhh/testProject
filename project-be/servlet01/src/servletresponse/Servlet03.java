package servletresponse;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    字节流

 */
@WebServlet("/resp03")
public class Servlet03 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //同时设置
        resp.setContentType("text/html;charset=UTF-8");

        //字节输出流
        ServletOutputStream out = resp.getOutputStream();
        //输出数据
        out.write("<h2>你好2</h2>".getBytes("UTF-8"));





    }
}
