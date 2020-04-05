class Solution {
    public int maxProfit(int[] prices) {
        // Sum in increasing total
        int sum = 0;
        for(int i = 1, hold = 0; i < prices.length; i ++) {
            if(prices[i] >= prices[hold]) {
                sum += (prices[i] - prices[hold]);
            }
            hold = i;
        }
        return sum;
    }
}