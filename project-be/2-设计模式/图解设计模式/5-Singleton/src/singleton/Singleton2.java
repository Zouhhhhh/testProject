package singleton;

public class Singleton2 {
    private static Singleton2 singleton;
    private Singleton2() {
        System.out.println("生成了一个实例。");
    }

    public static Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}