package com.zouhhhhh.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet("/upload")
public class UpLoadServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String img = req.getParameter("img");
//        System.out.println(img);      //null
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        InputStream inputStream = req.getInputStream();
//        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        String str = "";
//        while((str = bufferedReader.readLine()) != null) {
//            System.out.println(str);
//        }
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //通过输入流获取客户端传来的数据流
//        InputStream inputStream = req.getInputStream();
//        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        String str = "";
//
//        //通过输出流将数据流输出到本地硬盘
//        String filePath = req.getServletContext().getRealPath("file/copy.txt");
//        OutputStream outputStream = new FileOutputStream(filePath);
//        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        while((str = bufferedReader.readLine()) != null) {
//            bufferedWriter.write(str);
//        }
//
//        //关闭流
//        bufferedWriter.close();
//        writer.close();
//        bufferedReader.close();
//        reader.close();
//        inputStream.close();
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String img = req.getParameter("img");
        System.out.println(img);      //null
    }

}
