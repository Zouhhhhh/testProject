package 一_删除排序数组中的重复项;

public class Test {

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int index = 1;
        for (int i = 1; i < len; i++) {
            if (nums[index-1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

}
