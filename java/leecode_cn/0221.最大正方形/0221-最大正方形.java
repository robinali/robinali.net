class Solution {
    public int maximalSquare0(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxSqlen = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while(sqlen + i < rows && sqlen + j < cols && flag) {
                        for(int k = j; k <= sqlen + j; k++) {
                            if(matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for(int k = i; k <= sqlen + i; k++) {
                            if(matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            sqlen++;
                    }
                    maxSqlen = maxSqlen < sqlen? sqlen : maxSqlen;
                }
            }
        }
        return maxSqlen * maxSqlen;
    }
    
    public int maximalSquare1(char[][] matrix) {
        // dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSqlen = 0;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxSqlen = Math.max(maxSqlen, dp[i][j]);
                }
            }
        }
        return maxSqlen * maxSqlen;
    }
    
    public int maximalSquare(char[][] matrix) {
        // dp[j] = min(dp[j - 1], dp[j], prev) where prev referes to the old dp[j - 1]
        int rows = matrix.length, cols = rows > 0? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxSqlen = 0, prev = 0;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if(matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxSqlen = Math.max(dp[j], maxSqlen);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSqlen * maxSqlen;
    }
}