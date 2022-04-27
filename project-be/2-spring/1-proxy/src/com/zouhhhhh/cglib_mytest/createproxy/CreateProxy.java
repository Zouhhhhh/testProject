package com.zouhhhhh.cglib_mytest.createproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author zouhao
 * @date 2022/4/27
 */
public class CreateProxy {

    /**
     * 生成CGLIB代理对象
     * @param cla           被代理类
     * @param proxyObj      代理类（需实现MethodInterceptor接口）
     * @return              Class类的CGLIB代理对象
     */
    public static Object getProxy(Class cla, MethodInterceptor proxyObj) {
        // CGLIB enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cla);
        // 定义代理逻辑对象为实现了MethodInterceptor方法的对象
        enhancer.setCallback(proxyObj);
        // 生成并返回代理对象
        return enhancer.create();
    }

}
