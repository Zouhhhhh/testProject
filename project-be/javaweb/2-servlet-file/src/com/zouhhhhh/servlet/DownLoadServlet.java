package com.zouhhhhh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应方式
        resp.setContentType("application/x-msdownload");
        //设置下载之后的文件名
        String fileName = "1.png";
        resp.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        //获取输入流和输出流（从本地到response的输出流）
        String path = req.getServletContext().getRealPath("/file/" +  fileName);
        InputStream inputStream = new FileInputStream(path);
        OutputStream outputStream = resp.getOutputStream();
        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            outputStream.write(temp);
        }

        outputStream.close();
        inputStream.close();
    }
}
