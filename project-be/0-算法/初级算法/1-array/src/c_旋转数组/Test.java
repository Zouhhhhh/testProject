package c_旋转数组;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate3(nums, k);
    }

    // 使用临时数组
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] nums2 = new int[len];
        k = k % len;

        int index = 0;
        for(int i=len-k;i<len;i++,index++) {
            nums2[index] = nums[i];
        }

        for(int i=0;i<len-k;i++,index++) {
            nums2[index] = nums[i];
        }

        System.arraycopy(nums2, 0, nums, 0, len);

    }

    // 原地算法（超时了）
    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        for(int i=1;i<=k;i++) {

            int tmp = nums[len-1];
            for(int j=len-1;j>0;j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = tmp;

        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // 原地算法
    public static void rotate3(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        int tmp;
        // 全部反转
        for(int i=0;i<(len/2);i++) {
            tmp = nums[i];
            nums[i] = nums[len-i-1];
            nums[len-i-1] = tmp;
        }

        // 反转前面k个
        for(int i=0;i<(k/2);i++) {
            tmp = nums[i];
            nums[i] = nums[k-i-1];
            nums[k-i-1] = tmp;
        }

        // 反转后面
        for(int i=k;i<(len+ k)/2;i++) {
            tmp = nums[i];
            nums[i] = nums[len + k-i-1];
            nums[len + k-i-1] = tmp;
        }

        for(int num : nums) System.out.print(num + " ");

    }
}
