package com.kuang.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/t1", produces = "application/json;charset=utf-8")
    @ResponseBody       //这个注解就不会走视图解析器，返回字符串
    public String test1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        User user  = new User("zou", 3,"男");

        String str = mapper.writeValueAsString(user);

        return str;
    }

}
