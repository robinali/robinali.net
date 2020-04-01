class Solution {
    /**
    Note: example is all positive. In google interview, there could be negative number. In that case sum(0 ... i) is the sum of max sub array NOT sum. And the other Binary-search solution won't fit.

    Base Case: dp[0][1] = 0
    Induction Rule
    dp[i][j] : sum of sub-problem, splitting nums[0 ... j] into i groups
    dp[1][j] = sum(0 ... j)
    dp[i][j] = min(dp[i][j], max(dp[i - 1][k], sum(k + 1 ... j)) 0 <= k < j
    Time complexity: O(mn^2)
    Space complexity: O(mn)
    */
    public int splitArray(int[] nums, int m) {
        int[] sums = new int[nums.length + 1];
        int[][] dp = new int[nums.length + 1][m + 1];
        for(int[] inner : dp) {
            Arrays.fill(inner, Integer.MAX_VALUE);
        }
        sums[0] = nums[0];
        for(int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        dp[0][0] = 0;
        for(int i = 1; i <=  nums.length; i++) {
            for(int j = 1; j <= m; j++) {
                for(int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sums[i] - sums[k]));
                }
            }
        }
        return dp[nums.length][m];
    }
}