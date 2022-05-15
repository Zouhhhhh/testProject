package test;

import pojo.Employee;
import pojo.Manager;
import pojo.Pair;

public class Test {

    public static void main(String[] args) {
        Manager manager1 = new Manager();
        manager1.setName("first");
        Manager manager2 = new Manager();
        manager2.setName("second");
        Pair<Manager> pair = new Pair<>();
        pair.setFirst(manager1);
        pair.setSecond(manager2);


        // Test.printBuddies1(pair);  // error
        // right:参数可以是Pair<Manager>
        Test.printBuddies2(pair);
    }

    // 严格的泛型类型
    public static void printBuddies1(Pair<Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + second.getName());
    }


    public static void printBuddies2(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + second.getName());
    }



}
