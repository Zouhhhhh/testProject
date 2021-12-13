package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {

    //请求转发1
    @RequestMapping("/m1/t1")
    public String test(Model model) {
        model.addAttribute("msg", "modelTest1");
        return "/WEB-INF/jsp/hello.jsp";
    }

    //请求转发2
    @RequestMapping("/m1/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "modelTest2");
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    //重定向
    @RequestMapping("/m1/t3")
    public String test3(Model model) {
        model.addAttribute("msg", "modelTest3");
        return "redirect:/index.jsp";
    }




}
