package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cont01")
public class Context01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取
        ServletContext servletContext = req.getServletContext();

        //通过session对象获取
        ServletContext servletContext1 = req.getSession().getServletContext();

        //通过ServletConfig对象获取
        ServletContext servletContext2 = getServletConfig().getServletContext();

        //直接获取
        ServletContext servletContext3 = getServletContext();

        //常用方法

    }
}
