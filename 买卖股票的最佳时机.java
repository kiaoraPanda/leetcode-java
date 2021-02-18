public class 买卖股票的最佳时机 {
    // 数值比较注意用math中的方法优化
    public int maxProfit(int[] prices) {
        int mi = Integer.MAX_VALUE, ma = 0;

        for (int i = 0; i < prices.length; i++) {
            mi = Math.min(prices[i], mi);
            ma = Math.max(ma, prices[i] - mi);
        }
        return ma;
    }
}
