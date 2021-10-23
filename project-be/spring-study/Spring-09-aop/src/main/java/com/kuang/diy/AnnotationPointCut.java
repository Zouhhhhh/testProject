package com.kuang.diy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//标注这个类是一个切面
@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("方法执行前");
    }

    @After("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("方法执行后");
    }

    @Around("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void around() {
        System.out.println("around");
    }

}
