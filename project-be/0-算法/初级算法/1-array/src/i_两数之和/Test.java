package i_两数之和;

public class Test {
    public static void main(String[] args) {
        int[] nums = {0,4,3,0};
        int target = 0;
        int[] index = plus(nums, target);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
    }


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
}
