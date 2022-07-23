package i_两数之和;

import java.util.HashMap;
import java.util.Map;

public class Test {

    // 给一个数组和一个target，求出数组中两数之和等于target
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] index = plus2(nums, target);
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i] + " ");
        }
    }

    // 暴力
    public static int[] plus(int[] nums, int target) {
        int len = nums.length;
        int[] index = new int[2];

        for(int i=0;i<len;i++) {

//            if(nums[i] > target) continue;

            for(int j=i+1;j<len;j++) {
                if(nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }

        }
        return index;
    }

    // HashMap
    public static int[] plus2(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>(len/2);
//        map.put(nums[0], 0);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
