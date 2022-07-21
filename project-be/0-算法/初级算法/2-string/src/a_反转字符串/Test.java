package a_反转字符串;

public class Test {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        char tmp;
        for (int i = 0; i < len/2; i++) {
            tmp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = tmp;
        }
    }
}
