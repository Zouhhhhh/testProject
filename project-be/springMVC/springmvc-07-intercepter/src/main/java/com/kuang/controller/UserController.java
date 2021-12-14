package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/jumplogin")
    public String jumpLogin() throws Exception {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String pwd) throws Exception {
        System.out.println("前端接收userName + " + username);
        session.setAttribute("userLoginInfo", username);
        return "main";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/success")
    public String success() throws Exception {
        return "success";
    }



}
