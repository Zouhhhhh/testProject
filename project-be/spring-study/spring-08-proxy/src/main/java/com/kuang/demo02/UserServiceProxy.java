package com.kuang.demo02;

import org.springframework.web.servlet.support.JstlUtils;

public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        userService.add();
        log();
    }

    @Override
    public void delete() {
        userService.delete();
        log();
    }

    @Override
    public void update() {
        userService.update();
        log();
    }

    @Override
    public void query() {
        userService.query();
        log();
    }

    public void log() {
        System.out.println("打印日志");
    }

}
