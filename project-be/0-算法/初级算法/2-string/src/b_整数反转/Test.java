package b_整数反转;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int a = 132456;
        int b = reverse2(a);
        System.out.println(b);
    }

    // 怎么判断溢出？
    public static int reverse(int x) {
        List<Integer> list = new LinkedList<>();

        int index = 0;
        while(x != 0) {
            list.add( x % 10 );
            x = x / 10;
            index++;
        }

        if (index > 31) return 0;

        for (int i = 0; i < index; i++) {
            x = x*10+list.get(i);
        }

        return x;
    }


    public static int reverse2(int x) {

        int res = 0;
        int t = 0;
        int newRes = 0;
        while (x != 0) {
            t = x%10;
            newRes = res*10 + t;
            if ((newRes-t)/10 != res) return 0;

            res = res*10 + x % 10;
            x = x / 10;
        }
        return res;
    }

}
