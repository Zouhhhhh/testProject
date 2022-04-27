package com.zouhhhhh.cglib_mytest.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zouhao
 * @date 2022/4/27
 */
public class CglibProxyExample implements MethodInterceptor {
    /**
     * 代理逻辑方法
     * @param o             代理对象
     * @param method        方法
     * @param objects       方法参数
     * @param methodProxy   方法代理
     * @return              代理逻辑返回
     * @throws Throwable    异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前");
        // CGLIB反射调用真实对象方法
        Object result = methodProxy.invokeSuper(o, objects);
//        Object result = method.invoke(o, objects);
        System.err.println("调用真实对象后");
        return result;
    }
}
