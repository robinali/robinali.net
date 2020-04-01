class Solution {
    /**
    Base Case: dp[0][0]= 1, dp[0][1] = 0, dp[0][2] = 0
    Induction Rule
    dp[i][0] : ways to tile i cols while perfect fill
    dp[i][1] : ways to tile i cols while missing 1 in 1st row
    dp[i][2] : ways to tile i cols while missing 1 in 2nd row
    dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
    dp[i][1] = dp[i - 1][2]
    dp[i][2] = dp[i - 1][1]
    Time complexity: O(n)
    Space complexity: O(n) -> O(1)
    */
    public int numTilings0(int N) {
        long[][] dp = new long[N+1][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0;
        int MOD = 1000000007;
        for(int i = 1 ; i <= N ; ++i){
            long temp = i < 2 ? 0 : dp[i -2][0];
            dp[i][0] = (temp + dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (temp +dp[i-1][2]) % MOD;
            dp[i][2] = (temp +dp[i-1][1]) % MOD;
        }
        return (int)dp[N][0];

    }

    /**
    Base Case: dp[0][0]= 1, dp[0][1] = 0, dp[0][2] = 0
    Simplified Induction Rule
    Note: dp[i][1] is always equals to dp[i][2]
    dp[i][0] = dp[i - 1][0] + dp[i - 2][0]  + 2(dp[i - 1][1])
    dp[i][1] = dp[i - 2][0] + dp[i - 1][1]
    Time complexity: O(n)
    Space complexity: O(n) -> O(1)
    */
    public int numTilings(int N) {
        long[][] dp = new long[N+1][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0;
        int MOD = 1000000007;
        for(int i = 1 ; i <= N ; ++i){
            long temp = i < 2 ? 0 : dp[i -2][0];
            dp[i][0] = (temp + dp[i-1][0] + 2 * dp[i-1][1]) % MOD;
            dp[i][1] = (temp +dp[i-1][1]) % MOD;
        }
        return (int)dp[N][0];

    }

    /**
        Note: you can reduce space by only cache dp[i - 2][0] dp[i - 1][0], dp[i - 1][1]
    */
}