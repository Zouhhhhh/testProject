package c_字符串中的第一个唯一字符;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String s = "leetcode";
        int i = firstUniqChar3(s);
        System.out.println(i);
    }


    // 自制Hash表
    public static int firstUniqChar3(String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[chars[i] - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }


    // JAVA的API
    public static int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    // 暴力，两个for循环先把i后面重复的全部设为默认字符，然后再for一次找第一个不是默认字符的的
    // ajaxcktactrgdppqqvomqwosfothnjpljqqneudfftjsrabosxxovbdwtffnwiqvxpunfkicatxmwxlvweipumcovijelbuuldurumlqldmcnmmxutraogcdkqamnmuseprqlrcffexofgucmedhdqetmfrnmppfeacrajhkxoqhvfeavafndbgqrgfiiffpbjhoenkirqqnoddajhqknksqkdktqughmaiwhnjntloxqvrbgasptcqvxvchoetfvvwrbiglvhchlgxvfevktkofxuffqoebusqxshjboluuoetdftbvoswcupjlhkxsrupqbjiwipfwkxititewmjxdepadchgtlnkmxhvurmmoaalnmxapeacqiekdtoqjtvbteqpcskscoxobsnvgiggiqvvfaonfsuunqnxqlinledqikgjngedvlclilaopnjmtlouotpqjemraurglxjcodeducmcpxuidmswmuxavmmkcahtadwjlgtwbfjkoxgqwfkvsehpvgqchvxjekcknvodxwhmcmpnvmvsamhutilrnmsxpdwvcqwswdasmxgwpceeweaxfdtanvhfjqkbtpktoorenqmltowufdkbngqwaqptcxnwibtppfvquxqnlkmadterblttvvsccramcqbnrjrqalttnufkbspxlquitdhjjvsuxsdwejaudnufdncsijktkwkuulpaanuvrirqbxqkuouemfdohqowgvopxfrifpfxwkegojrmletpqepingshxfxcejwqsmwlqxmfnaebhxaopchiunhxnfoelxfavmxqgjapeejscrdjbocultnvixdnuhxbihhghwrcffhwlioborjorjlbqjfnhaukrvgfvhpbotxndggngdunihklnumfmtdlcnggxerbbnrpqrgocukspvjuhirutiensjmavupenulflsecaedmglbdhmmtmpbhbpdepjsssqiwuqilbcid
    // 超时了
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean hasSame;
        for (int i = 0; i < len-1; i++) {
            hasSame = false;
            for (int j = i+1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    chars[j] = '\u0000';
                    hasSame = true;
                }
            }
            if (hasSame) chars[i] = '\u0000';
        }


        for (int i = 0; i < len; i++) {
            if (chars[i] != '\u0000') {
                return i;
            }
        }

        return -1;
    }

}
