package generic_variable;

import generic_valiable.Pair;

import java.time.LocalDate;

public class PairTest {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22)
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());
    }
}


class ArrayAlg {

    // 对类型变量T设置一个限定类型
    // 限定类型用 & 分隔， 类型变量用逗号 , 分隔
    public static <T extends Comparable> generic_valiable.Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
