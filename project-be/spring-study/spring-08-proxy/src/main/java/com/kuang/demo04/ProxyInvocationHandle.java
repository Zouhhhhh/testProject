package com.kuang.demo04;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类自定生成代理
public class ProxyInvocationHandle implements InvocationHandler {

    //被代理的接口
    private Object target;

    public void setRent(Object target) {
        this.target = target;
    }

    //生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //处理代理实例，返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理的本质，就是使用反射机制实现！
        log(method.getName());
        Object result = method.invoke(target, args);

        return result;
    }

    public void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }

}
