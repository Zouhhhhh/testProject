package comprehensive;

import pojo.Pair;

/**
 * @author zouhao
 * @date 2022/5/17
 */
public class PairAlg {

    /**
     * 判断Pair中是否有null
     * 使用无限定通配符，get方法只需要Object
     * @param pair
     * @return
     */
    public static boolean hasNull(Pair<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    /**
     * 交换Pair的first和second
     * 使用无限定通配符
     * @param pair
     */
    public static void swap(Pair<?> pair) {
        // 通配符捕获
        swapHelper(pair);
    }


    /**
     * 交换Pair的first和second
     * 使用泛型方法
     * @param pair
     * @param <T>
     */
    public static <T> void swapHelper(Pair<T> pair) {
        T t = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
    }
}
