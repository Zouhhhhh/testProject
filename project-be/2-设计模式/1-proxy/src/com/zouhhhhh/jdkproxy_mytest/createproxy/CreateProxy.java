package com.zouhhhhh.jdkproxy_mytest.createproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class CreateProxy {

    public static Object createProxy(Object target, InvocationHandler proxy) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces()
                , proxy);
    }

}
