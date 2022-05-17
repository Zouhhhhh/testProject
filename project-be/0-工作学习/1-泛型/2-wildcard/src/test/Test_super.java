package test;

import pojo.Boss;
import pojo.Employee;
import pojo.Manager;
import pojo.Pair;

public class Test_super {

    public static void main(String[] args) {
        Pair<Employee> employeePair = new Pair<>();
        Pair<? super Manager> wildcard = employeePair;

        Employee employee = new Employee();
        Manager manager = new Manager();
        Boss boss = new Boss();

        wildcard.setFirst(manager);    // right
        wildcard.setFirst(boss);     // right
        Object e = wildcard.getFirst();  // right

//        Manager m = wildcard.getFirst();  // error
    }


    // Pair<? super Employee>类型擦除后，Pair的类如下：
    /**
     calss Pair {

        private ? super Employee first;

         ? super Employee getFirst();
         void setFirst(? super Employee e) {
            this.first = e;
        }

        set方法的参数e，指明了是Employee或者其父类引用，那么传进来的对象就可以是Employee或者其子类
        父类引用可以指向子类对象，所以没问题，set方法可以被调用

        但是get方法返回一个是Employee的父类对象，但具体是哪个父类不知道
        所以get方法调用后，只能用Object来接

     }
     **/


    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.getBonux() > a[i].getBonux()) {
                min = a[i];
            }
            if (max.getBonux() < a[i].getBonux()) {
                max = a[i];
            }
        }
        result.setFirst(max);
        result.setSecond(min);
    }

}
