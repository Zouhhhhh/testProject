package generic_bridgemethod;




/**
 * 定义时的T是类型变量
 * 表明是什么类型时的T是类型参数
 * @author zouhao
 * @date 2022/5/14
 * @param <T>
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() { first = null; second = null;}
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
