package com.zouhhhhh.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    //不是文件
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println(" name: "+ name + " value: " + value );
                } else {
                    //是文件
                    String fileName = fileItem.getName();
                    long size = fileItem.getSize();
                    System.out.println(fileName + ":" + size + "byte");
                    InputStream inputStream = fileItem.getInputStream();
                    String path = req.getServletContext().getRealPath("file/" + fileName);
                    OutputStream outputStream = new FileOutputStream(path);
                    int temp = 0;
                    while ((temp = inputStream.read()) != -1) {
                        outputStream.write(temp);
                    }
                    outputStream.close();
                    inputStream.close();
                    System.out.println("上传成功");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

}
