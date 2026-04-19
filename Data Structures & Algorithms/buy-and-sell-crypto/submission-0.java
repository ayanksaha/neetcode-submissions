class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int maxPrice = prices[n-1];
        int maxProfit = 0;

        for (int i = n-2; i>=0; i--) {
            final int currentPrice = prices[i];

            if (currentPrice > maxPrice) {
                maxPrice = currentPrice;
            } else {
                maxProfit = Math.max(maxProfit, maxPrice - currentPrice);
            }
        }

        return maxProfit;
    }
}
