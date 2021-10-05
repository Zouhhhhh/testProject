package documentUploadAndDown;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


@WebServlet("/uploadServlet")
@MultipartConfig    //文件上传，必须要设置该注解
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件上传...");
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");

        //获取普通表单项
        String uname = req.getParameter("uname");
        System.out.println(uname);

        //获取Part对象，Servlet将 multipart/form-data 的POST请求封装成Part对象
        Part part = req.getPart("myfile");
        //通过Part对象获得上传的文件名
        String fileName = part.getSubmittedFileName();
        System.out.println(fileName);

        //得到文件存放的路径
        String filePath = req.getServletContext().getRealPath("/");
        System.out.println(filePath);
        //上传文件到指定目录
        part.write(filePath + "/" + fileName);
    }
}
