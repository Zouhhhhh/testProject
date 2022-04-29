package com.zouhhhhh.jdkproxy.test;


import com.zouhhhhh.jdkproxy.proxy.JdkProxyExample;
import com.zouhhhhh.jdkproxy.real.HelloWorld;
import com.zouhhhhh.jdkproxy.real.HelloWorldImpl;

/**
 * @author zouhao
 * @date 2022/4/27
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        // 绑定关系，因为挂在接口HelloWorld下，所以声明代理对象HelloWorld proxy
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        // 注意，此时HelloWorld对象已经是一个代理对象，它会进入代理的逻辑方法invoke里
        proxy.sayHelloWorld();
    }

}
