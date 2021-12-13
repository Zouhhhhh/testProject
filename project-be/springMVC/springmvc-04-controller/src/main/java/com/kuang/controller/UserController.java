package com.kuang.controller;

import com.kuang.pojo.User;
import org.junit.runners.Parameterized;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(String name, Model model) {

        System.out.println("前端参数" + name);
        model.addAttribute("msg", name);

        return "test";
    }

    @GetMapping("/t2")
    public String test2(@RequestParam("userName") String name, Model model) {
        model.addAttribute("msg", name);
        return "hello";
    }

    //前端接收的是一个对象：id、name、age
    @GetMapping("/t3")
    public String test3(User user, Model model) {
        System.out.println(user.toString());
        return "test";
    }

    @GetMapping("/t4")
    public String test4(ModelMap map) {

        return "test";
    }

}
