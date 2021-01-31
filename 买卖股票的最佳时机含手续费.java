public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        int hold = -(prices[0] + fee);
        int noHold = 0;
        for (int i = 1; i < length; i++) {
            hold = Math.max(hold, noHold - (prices[i] + fee));
            noHold = Math.max(noHold, hold + prices[i]);
        }
        return noHold;
    }
}
