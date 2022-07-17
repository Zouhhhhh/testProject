package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("myController")
@RequestMapping("/my")
public class MyController {

    @RequestMapping("/index.do")
    public ModelAndView index() {
        // 模型和视图
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
