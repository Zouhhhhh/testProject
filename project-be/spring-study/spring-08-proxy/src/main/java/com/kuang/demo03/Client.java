package com.kuang.demo03;

public class Client {

    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色，现在没有
        ProxyInvocationHandle pih = new ProxyInvocationHandle();
        //通过调用程序处理角色来处理我们要调用的接口对象
        pih.setRent(host);   //设置代理对象

        Rent proxy = (Rent) pih.getProxy(); //这里的proxy就是动态生成的代理类
        proxy.rent();

    }

}
