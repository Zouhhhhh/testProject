package d_有效的字母异位词;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String s = "aa";
        String t = "bb";

        boolean isAnagrams = isAnagram3(s, t);
        System.out.println(isAnagrams);
    }


    // 先排序，再比较
    public static boolean isAnagram3(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        //对两个字符串中的字符进行排序
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }



    // hash数组，计算两个字符串出现的字符次数
    public static boolean isAnagram2(String s, String t) {
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            hash1[s.charAt(i) - 'a']++;
            hash2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] != hash2[i]) return false;
        }

        return true;
    }


    // 异或运算不行
    public static boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        if (sChar.length != tChar.length) return false;

        int resulta = sChar[0];
        int resultb = tChar[0];

        for (int i = 1; i < sChar.length; i++) {
            resulta = resulta ^ sChar[i] ;
            resultb = resultb ^ tChar[i] ;
        }

        return (resulta == resultb) ;
    }
}
