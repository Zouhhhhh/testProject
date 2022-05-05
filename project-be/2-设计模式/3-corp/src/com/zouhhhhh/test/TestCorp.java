package com.zouhhhhh.test;

import com.zouhhhhh.proxy.JdkProxy;
import com.zouhhhhh.real.HelloWorld;
import com.zouhhhhh.real.HelloWorldImpl;

/**
 * @author zouhao
 * @date 2022/5/5
 */
public class TestCorp {
    public static void main(String[] args) {
        // 责任链模式
        HelloWorld helloWorld1 = (HelloWorld) JdkProxy.bind(new HelloWorldImpl(), "com.zouhhhhh.interceptor.Interceptor1");
        HelloWorld helloWorld2 = (HelloWorld) JdkProxy.bind(helloWorld1, "com.zouhhhhh.interceptor.Interceptor2");
        HelloWorld helloWorld3 = (HelloWorld) JdkProxy.bind(helloWorld2, "com.zouhhhhh.interceptor.Interceptor3");
        helloWorld3.sayHelloWorld();
    }
}
