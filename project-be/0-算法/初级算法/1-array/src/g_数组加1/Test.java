package g_数组加1;

public class Test {


    public static void main(String[] args) {
        int[] nums = {9};
        int[] nums2 = plusOne(nums);
        for (int i : nums2) {
            System.out.print(i + " ");
        }
    }


    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len-1] += 1;
        int[] result = new int[len + 1];
        int tmp = 0;

        for (int i = len-1; i >= 0; i--) {

            result[i+1] += digits[i];
            tmp = result[i+1] / 10;
            if (tmp != 0) {
                result[i+1] %= 10;
                result[i] += tmp;
            }
        }

        if (result[0] == 0) {
            for (int i = 0; i < digits.length; i++) {
                digits[i] = result[i+1];
            }
            return digits;
        }

        return result;
    }
}
