package com.kuang.onlytest;

public class ClassTest {

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


