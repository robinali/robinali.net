class Solution {
    public int checkRecord(int n) {
        // f[i] = 2f[i - 1] + f[i - 4]
        long max = 1000000007;
        long[] f = new long[n <= 5 ? 6: n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for(int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % max + (max - f[i - 4])) % max;
        long sum = f[n];
        for(int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % max;
        }
        return (int) (sum % max);
    }
}