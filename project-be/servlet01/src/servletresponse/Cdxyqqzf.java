package servletresponse;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    重定向与请求转发的区别
        1. 请求转发的地址栏不会发生改变，重定向的地址栏会改变
        2. 请求转发只有一次请求，重定向有两次请求
        3. 请求转发时request对象可共享，重定向时request不共享
        4. 请求转发是服务端行为，重定向是客户端行为
        5. 请求转发的地址只能是当前站点下的资源，重定向可以跨域
 */
@WebServlet("/Cdxyqqzf")
public class Cdxyqqzf extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重定向与请求转发");
        //接收参数
        String name = req.getParameter("name");
        System.out.println(name);

        //设置request域对象
        req.setAttribute("pwd","123456");

        //请求转发
//        req.getRequestDispatcher("cdxyqqzf.jsp").forward(req, resp);

        //重定向
        resp.sendRedirect("cdxyqqzf.jsp");


    }
}
