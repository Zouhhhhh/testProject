package c_字符串中的第一个唯一字符;

public class Test {
    public static void main(String[] args) {
        String s = "leetcode";


    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (chars[i] == chars[j]) {

                }
            }

        }

    }

}
