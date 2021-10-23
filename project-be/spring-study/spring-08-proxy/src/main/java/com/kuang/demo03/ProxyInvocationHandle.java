package com.kuang.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类自定生成代理
public class ProxyInvocationHandle implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //处理代理实例，返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理的本质，就是使用反射机制实现！
        seeHouse();
        Object result = method.invoke(rent, args);
        fare();

        return result;
    }

    public void seeHouse() {
        System.out.println("中介带看房子");
    }

    public void fare() {
        System.out.println("中介收中介费");
    }
}
