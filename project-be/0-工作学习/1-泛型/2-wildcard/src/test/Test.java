package test;

import pojo.Employee;
import pojo.Manager;
import pojo.Pair;

public class Test {

    public static void main(String[] args) {
        Pair<Manager> pair = new Pair<>();
        Manager m1 = new Manager();
        m1.setName("manager1");
        Manager m2 = new Manager();
        m2.setName("manager2");

        pair.setFirst(m1);
        pair.setSecond(m2);

        // print1(pair);
        print4(pair);

    }

    // 严格的泛型类型
    public static void print1(Pair<Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();

        System.out.println("print1 : " + first.getName() + " " + second.getName());
    }

    // 泛型方法
    public static <T> void print2(Pair<T> p) {
        T first = p.getFirst();
        T second = p.getSecond();

        System.out.println("print2 : " + first.toString() + " " + second.toString());
    }

    // 无限定通配符，get方法只能返回Object，不能调用set方法
    public static void print3(Pair<?> p) {
        Object first = p.getFirst();
        Object second = p.getSecond();
    }

    // 上界通配符（子类型限定通配符）：只能调用get方法
    public static void print4(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println("print3 : " + first.getName() + " " + second.getName());
    }

    // 下界通配符（超类型限定通配符）：只能调用set方法，get方法只能用Object引用去接
    public static void print5(Pair<? super Manager> p) {
        Manager first = new Manager();
        Manager second = new Manager();
        p.setFirst(second);
        p.setSecond(first);
    }



}
