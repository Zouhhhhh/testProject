package com.zouhhhhh.interceptor;

import java.lang.reflect.Method;

/**
 * @author zouhao
 * @date 2022/5/5
 */
public interface Interceptor {

    /**
     * 调用真实对象前方法
     * @param proxy
     * @param target
     * @param method
     * @param args
     * @return
     */
    boolean before(Object proxy, Object target, Method method, Object[] args);

    /**
     * before方法返回false时的方法
     * @param proxy
     * @param target
     * @param method
     * @param args
     */
    void around(Object proxy, Object target, Method method, Object[] args);

    /**
     * 调用真实对象方法获around方法后
     * @param proxy
     * @param target
     * @param method
     * @param args
     */
    void after(Object proxy, Object target, Method method, Object[] args);

}
