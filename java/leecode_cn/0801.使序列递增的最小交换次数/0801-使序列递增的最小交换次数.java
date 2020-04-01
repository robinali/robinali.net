class Solution {
    public int minSwap(int[] A, int[] B) {
        if(A.length == 0 || A.length != B.length) return 0;
        int[][] dp = new int[2][A.length];
        for(int inner[] : dp) {
            Arrays.fill(inner, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        dp[1][0] = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[0][i] = Math.min(dp[0][i], dp[0][i - 1]);
                dp[1][i] = dp[1][i - 1] + 1;
            }
            if(A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[0][i] = Math.min(dp[0][i], dp[1][i - 1]);
                dp[1][i] = dp[0][i - 1] + 1;
            }
        }
        return Math.min(dp[0][A.length -1], dp[1][A.length - 1]);
    }
}