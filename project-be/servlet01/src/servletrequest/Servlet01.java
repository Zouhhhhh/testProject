package servletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/req01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 常用方法 */
        //获取请求时的完成路径，从hhtp开始，到？结束
        String url = req.getRequestURL() + "";
        System.out.println(url);

        //获取请求时的部分路径，从项目的站点名开始，到？结束
        String uri = req.getRequestURI();
        System.out.println(uri);

        //获取请求的参数字符串，从？后面开始
        String params = req.getQueryString();
        System.out.println(params);

        //获取请求方法，get和post
        String method = req.getMethod();
        System.out.println(method);

        //获取当前的协议版本，http/1.1
        String protocol = req.getProtocol();
        System.out.println(protocol);

        //获取项目的站点名，对外访问路径
        String webApp = req.getContextPath();
        System.out.println(webApp);


        /*  获取请求参数的方法  */
        //获取指定名称的参数值，返回字符串
        String name = req.getParameter("name");
        String psw = req.getParameter("psw");
        System.out.println(name);
        System.out.println(psw);

        //获取指定名称的所有参数值（复选框），返回字符串数组
        String[] hobbys = req.getParameterValues("hobby");
//        if (hobbys != null && hobbys.length > 0) {
//            for (String hobby : hobbys) {
//                System.out.println("爱好:" + hobby);
//            }
//        }
        System.out.println(hobbys.toString());

    }
}
