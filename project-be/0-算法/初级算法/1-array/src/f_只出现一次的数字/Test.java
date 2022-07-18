package f_只出现一次的数字;

public class Test {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int number = findNumber(nums);
        System.out.println(number);
    }

    // 位运算：异或
    /** 异或的性质：
     *  1、交换律
     *
     * 2、结合律 (a^ b)^ == a^ (b^c)
     *
     * 3、对于任何数x，都有 x^ x=0，x^0=x
     *
     * 4、自反性: a^ b^ b =a^0=a;
     *
     */
    public static int findNumber(int[] nums) {

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

}
