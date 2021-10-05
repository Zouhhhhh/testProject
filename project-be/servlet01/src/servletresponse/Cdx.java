package servletresponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*

    重定向
        服务端指导，客户端行为
        存在两次请求
        地址栏会发生改变
        Request对象不共享

 */

@WebServlet("/cdx")
public class Cdx extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重定向。。。");

        String name = req.getParameter("name");
        System.out.println(name);

        //重定向到cdx02
        resp.sendRedirect("cdx02");
    }
}
