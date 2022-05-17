package comprehensive;

import pojo.Employee;
import pojo.Manager;
import pojo.Pair;

/**
 * @author zouhao
 * @date 2022/5/17
 */
public class Main {

    public static void main(String[] args) {
        // var是jdk10 的新特性
        var ceo = new Manager("Gus Greedy", 800000);
        var cfo = new Manager("Sid Sneaky", 600000);
        var buddies = new Pair<Manager>(ceo, cfo);
        printBuddies(buddies);

        Manager[] managers = {ceo, cfo};
        var result = new Pair<Employee>();
        minmaxBonus(managers, result);
        System.out.println("===========================");
        System.out.println("min first: " + result.getFirst().getName());
        System.out.println("max second: " + result.getSecond().getName());

        maxminBonus(managers, result);
        System.out.println("===========================");
        System.out.println("min first: " + result.getFirst().getName());
        System.out.println("max second: " + result.getSecond().getName());



    }

    /**
     * 打印Pair
     * @param pair
     */
    public static void printBuddies(Pair<? extends Employee> pair) {
        Employee first = pair.getFirst();
        Employee second = pair.getSecond();
        System.out.println("print : " + first.getName() + " and " + second.getName());
    }

    /**
     * 将数组a中最小最大的元素放入Pair中
     * @param a
     * @param result
     */
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

        result.setFirst(min);
        result.setSecond(max);
    }

    /**
     * 将数组a中最大最小的元素放入Pair中
     * @param a
     * @param result
     */
    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
//        PairAlg.swap(result);
        PairAlg.swapHelper(result);
    }


}
