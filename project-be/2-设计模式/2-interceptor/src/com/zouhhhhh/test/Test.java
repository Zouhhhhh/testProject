package com.zouhhhhh.test;

import com.zouhhhhh.proxy.InterceptorJdkProxy;
import com.zouhhhhh.real.HelloWorld;
import com.zouhhhhh.real.HelloWorldImpl;

public class Test {

    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "com.zouhhhhh.interceptor.MyInterceptor");
        helloWorld.sayHelloWorld();
    }

}
