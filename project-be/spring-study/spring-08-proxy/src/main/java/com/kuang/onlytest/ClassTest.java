package com.kuang.onlytest;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {

    //获得类的信息
    @Test
    public void test() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        Class c1 = Class.forName("com.kuang.onlytest.User");

        User user = new User();
        c1 = user.getClass();

        //获得类的名字
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        //获得类的属性
//        Field[] fields = c1.getFields();  //只能获得public属性
        Field[] fields = c1.getDeclaredFields();    //找到所有属性
        for (Field f : fields) {
            System.out.println(f);
        }

        Field name = c1.getDeclaredField("name");
        System.out.println(name);


        System.out.println("=====================");
        //获得类的方法
        Method[] methods = c1.getMethods();     //除了本类以及父类的public方法
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("=====================");
        methods = c1.getDeclaredMethods();      //获得本类的所有方法
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("=====================");
        Method m = c1.getMethod("getName", null);
        Method m2 = c1.getMethod("setName", String.class);
        System.out.println(m2);


        System.out.println("=====================");
        Constructor cs = c1.getDeclaredConstructor(String.class);
        System.out.println("获得指定构造器 " + cs);


    }




    public static void main(String[] args) {
        Person person = new Student();
        System.out.println("这个人是" + person.name);

        //方式一：通过具体类获得
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过对象获得
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三：通过Class静态方法forName()获得
        try {
            Class clazz3 = Class.forName("com.kuang.onlytest.Teacher");
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}


