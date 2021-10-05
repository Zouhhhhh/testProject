package documentUploadAndDown;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件下载...");
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取参数（需要下载的文件夹）
        String fileNmae = req.getParameter("fileName");

        //参数非空判断
        if (fileNmae == null || "".equals(fileNmae.trim())) {
            resp.getWriter().write("请输入要下载的文件名");
            resp.getWriter().close();
            return ;
        }

        //获得文件存放的路径
        String path = req.getServletContext().getRealPath("/download/");

        System.out.println(path + fileNmae);

        //通过路径得到file对象
        File file = new File(path + fileNmae);

        //判断文件对象是否存在，且是标准文件
        if (file.exists() && file.isFile()) {

            //设置响应类型，浏览器无法使用某种方式或激活某个程序来处理的 MIME 类型
            resp.setContentType("application/x-msdownload");

            //设置响应头
            resp.setHeader("Content-Disposition", "attachment;filename=" + fileNmae);

            //获得file文件输入流
            InputStream inputStream = new FileInputStream(file);
            //获得字节输出流
            ServletOutputStream servletOutputStream = resp.getOutputStream();
            //定义byte数组
            byte[] bytes = new byte[1024];
            //定义长度
            int len = 0;

            //循环输出
            while ((len = inputStream.read(bytes)) != -1) {
                // 输出内容
                servletOutputStream.write(bytes, 0, len);
            }

            //关闭资源
            servletOutputStream.close();
            inputStream.close();

        } else {
            resp.getWriter().write("文件不存在，请重试");
            resp.getWriter().close();
        }

    }
}
