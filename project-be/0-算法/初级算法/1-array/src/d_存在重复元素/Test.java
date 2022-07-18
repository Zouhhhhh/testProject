package d_存在重复元素;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        if (containsDuplicate(nums)) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }

    }


    // 用Set集合
    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length -1;
        HashSet set = new HashSet(len);
        set.add(nums[len]);
        while(len-- > 0) {
            if(!set.add(nums[len])) return true;
        }

        return false;
    }




}
