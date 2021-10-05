package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ser05")
public class ServletLive extends HttpServlet {

    //服务器自动调用，当有请求到达servlet时，就会调用
    //可调用多次
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了service方法");
    }

    //初始化方法，服务器自动调用，当请求到达Servlet容器时，
    // 判断该Servlet对象是否存在，不存在则创建实例并初始化
    @Override
    public void init() throws ServletException {
        System.out.println("调用了init方法");
    }

    //销毁方法
    //只调用一次
    @Override
    public void destroy() {
        System.out.println("调用了destroy方法");
    }

}
