package 二_买卖股票的最佳时机2;

public class Greedy {
    public static void main(String[] args) {
        int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};
        int count = maxProfit(prices);
        System.out.println(count);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                max += prices[i+1] - prices[i];
            }
        }
        return max;
    }

}
