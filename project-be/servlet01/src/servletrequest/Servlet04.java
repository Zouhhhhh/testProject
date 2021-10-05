package servletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发跳转
 *  request.getRequestDispatcher(url).forward(request, respond);
 *  可以让请求从服务器跳转到客户端（或者跳转到指定的Servlet）
 *  服务端行为
 *  特点：
 *      1. 地址栏不发生改变
 *      2. 服务端行为
 *      3. 只有一个请求
 *
 */
@WebServlet("/req04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("Servlet04 name :" + name);
    }
}
