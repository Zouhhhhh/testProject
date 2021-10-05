package servletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * request作用域
 *
 *
 */
@WebServlet("/req05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet05");

        //设置域对象内容
        req.setAttribute("name", "admin");
        req.setAttribute("age", 18);
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        req.setAttribute("list", list);

        //请求转发给Servlet06
//        req.getRequestDispatcher("req06").forward(req, resp);

        //请求转发给JSP，并通过域对象传递数据
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
