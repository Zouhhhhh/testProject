package test;

import pojo.Employee;
import pojo.Manager;
import pojo.Pair;

public class Test_extends {



    public static void main(String[] args) {
        Pair<Manager> managerPair = new Pair<>();
        Pair<? extends Employee> wildcard = managerPair;

        Employee employee = new Employee();
        Manager manager = new Manager();
        // wildcard拒绝传递任何特定的类型
//        wildcard.setFirst(employee);    // error
//        wildcard.setFirst(manager);     // error

        Employee e = wildcard.getFirst();  // right
    }


    // Pair<? extends Employee>类型擦除后，Pair的类如下：
    /**
    calss Pair {

        ? extends Employee getFirst();
        void setFirst(? extends Employee e);

        看set方法参数那里就行了，e指明了只接收Employee的子类
        但是具体是哪个子类不知道，而且子类之间是不能赋值的，仅仅在这里就如何都调用不了set方法了

    }
    **/

}
