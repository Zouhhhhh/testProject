package com.zouhhhhh.cglib.test;

import com.zouhhhhh.cglib.proxy.CglibProxyExample;
import com.zouhhhhh.cglib.real.ReflectServiceImpl;
/**
 * @author zouhao
 * @date 2022/4/27
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl) cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHelloWorld();
    }

}
