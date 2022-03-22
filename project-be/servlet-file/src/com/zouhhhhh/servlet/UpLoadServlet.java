package com.zouhhhhh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/upload")
public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String img = req.getParameter("img");
//        System.out.println(img);      //null

        InputStream inputStream = req.getInputStream();
        int temp = 0;
        while((temp = inputStream.read()) != -1) {
            System.out.println(temp);
        }



    }
}
