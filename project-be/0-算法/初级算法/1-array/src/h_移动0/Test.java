package h_移动0;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        removeZero2(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // 类似冒泡排序（太慢了）
    public static void removeZero(int[] nums) {
        int len = nums.length;

        if(len == 1) return ;

        for(int i=0;i<len;i++) {

            for(int j=0;j<len-i-1;j++) {
                if(nums[j] == 0) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    // 单指针，将非0往前移，最后的全补0
    public static void removeZero2(int[] nums) {
        int len = nums.length;
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; index < len; index++) {
            nums[index] = 0;
        }

    }
}
