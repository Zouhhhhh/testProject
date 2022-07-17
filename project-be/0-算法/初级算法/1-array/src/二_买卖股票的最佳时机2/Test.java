package 二_买卖股票的最佳时机2;

public class Test {


    // 其实就是找这个数组中有几个递增的子数组
    public static void main(String[] args) {
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {2,4,1};
//        int[] prices = {6,1,3,2,4,7};
        int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int left = 0;
        int count = 0;

        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                left = i;
                break;
            }
        }

        for (int i = left; i < len-1; i++) {

            if (i == len-2 && prices[i] <= prices[i+1]) {
                count += prices[i+1] - prices[left];
            }

            if (prices[i] > prices[i+1]) {
                count += prices[i] - prices[left];
                left = i+1;
            }
        }

        System.out.println(count);
        return count;
    }


}
