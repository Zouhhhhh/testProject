package generic_method;

public class Test {
    public static void main(String[] args) {
//        String middle = ArrayAlg.getMiddle("Mary", "had", "a", "little", "lamb");
//        String middle = ArrayAlg.getMiddle();
        int middle = ArrayAlg.getMiddle(1, 4, 3, 2);
        System.out.println("middle = " + middle);
    }
}


class ArrayAlg {

    // 定义泛型方法
    // 类型变量，在修饰符后，返回值前
    public static <T> T getMiddle(T... a) {
        return a.length > 0 ? a[a.length / 2] : null;
    }

}
