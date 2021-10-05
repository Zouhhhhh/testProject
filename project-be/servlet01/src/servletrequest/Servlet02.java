package servletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求乱码问题
 *          Tomcat8以上版本
 *  Get请求   不会乱码
 *  Post请求  会乱码
 *
 *  解决；设置服务器解析编码的格式
 *  request.setCharacterEncoding("UTF-8")
 *
 *
 */
@WebServlet("/req02")
public class Servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");

        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        System.out.println(uname);
        System.out.println(upwd);

    }
}
