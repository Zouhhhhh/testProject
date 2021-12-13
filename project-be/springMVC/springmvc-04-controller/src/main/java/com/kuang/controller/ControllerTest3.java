package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerTest3 {

    @RequestMapping(value = "/commit/{p1}/{p2}", method = RequestMethod.POST)
    public String test1(@PathVariable int p1, @PathVariable int p2, Model model) {
        int res = p1 + p2;
        model.addAttribute("msg", res);
        return "test";
    }

    @GetMapping("add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "方法2" + res);
        return "test";
    }

}
