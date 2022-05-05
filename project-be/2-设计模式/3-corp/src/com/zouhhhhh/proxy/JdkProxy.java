package com.zouhhhhh.proxy;

import com.zouhhhhh.interceptor.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zouhao
 * @date 2022/5/5
 */
public class JdkProxy implements InvocationHandler {

    private Object target;
    private String interceptor = null;

    public JdkProxy(Object target, String interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    public static Object bind(Object target, String interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces(), new JdkProxy(target, interceptor));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (this.interceptor == null) {
            return method.invoke(target, args);
        }

        Object result = null;
        Interceptor interceptor = (Interceptor) Class.forName(this.interceptor).newInstance();
        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(target, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);

        return result;
    }
}
