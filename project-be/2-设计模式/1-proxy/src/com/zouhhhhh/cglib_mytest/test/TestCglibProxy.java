package com.zouhhhhh.cglib_mytest.test;

import com.zouhhhhh.cglib_mytest.createproxy.CreateProxy;
import com.zouhhhhh.cglib_mytest.proxy.CglibProxyExample;
import com.zouhhhhh.cglib_mytest.real.ReflectServiceImpl;

/**
 * @author zouhao
 * @date 2022/4/27
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl) CreateProxy.getProxy(ReflectServiceImpl.class, cpe);
        // 其实这里会涉及3个对象
        // 1：真实对象（ReflectServiceImpl）
        // 2. 代理对象（CglibProxyExample）
        // 3. 增强者（Enhancer）
        // 定义好真实对象与代理对象，并且代理对象需实现MethodInterceptor接口
        // 首先由Enhance增强者把代理对象进行“加工”，指定它代理哪个真实对象
        // 然后获取到“加工”后的代理对象，但是用真实对象的引用去指向它
        // 当调用方法时，就会进入到代理对象的intercept方法中（参数分别为：）

        obj.sayHelloWorld();




    }

}
