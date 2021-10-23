package com.kuang.onlytest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreatedClassTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("com.kuang.onlytest.User");

        //通过newInstance创建对象
        User u = (User)c1.newInstance();
        System.out.println(u.toString());
//
        //通过构造器创建对象
        Constructor c = c1.getDeclaredConstructor(String.class);
        User user = (User)c.newInstance("zouhao");
        System.out.println(user.toString());

        //通过反射调用普通方法，获取方法 -> 激活方法invoke（对象， "方法的参数"）
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "zou");
        System.out.println(user3);

        //通过反射操作属性，如果是private，需要关闭权限检测
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user3, "hah");
        System.out.println(user3);


    }

}
