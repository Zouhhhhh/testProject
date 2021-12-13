package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller         //里面的方法的返回值会被视图解析器处理
//@RestController     //不会被视图解析器处理，只返回json字符串
@RequestMapping("/hello")
public class HelloController {

    // localhost:8080/hello/h1
    @RequestMapping("/h1")
    public String hello(Model model) {
        //封装数据
        model.addAttribute("msg", "Hello,springMVCAnnotation");
        return "hello"; //会被视图解析器处理
    }

}
