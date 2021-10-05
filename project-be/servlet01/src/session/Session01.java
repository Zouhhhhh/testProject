package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/*

    Session对象
        request.getSession()
        当获取Session对象时，会先判断是否存在，存在则获取，否则创建
    常用方法：


 */

@WebServlet("/session01")
public class Session01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session
        HttpSession session = req.getSession();

        //获取会话标识符       JSESSIONID唯一标识符
        String id = session.getId();
        System.out.println(id);

        //获取Session的创建时间
        System.out.println(session.getCreationTime());

        //获取最后一次访问时间
        System.out.println(session.getLastAccessedTime());

        //判断是否是新的Session对象
        System.out.println(session.isNew());

    }
}
