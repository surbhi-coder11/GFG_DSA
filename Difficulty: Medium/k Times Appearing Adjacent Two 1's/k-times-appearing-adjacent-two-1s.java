class Solution {
    public int countStrings(int n, int k) {
        // If k is greater than or equal to n, it's impossible to have k adjacent pairs
        if (k >= n) {
            return 0;
        }
        
        long MOD = 1000000007L;
        
        // dp[i][j][last_bit]
        long[][][] dp = new long[n + 1][k + 1][2];
        
        // Base cases for string of length 1
        dp[1][0][0] = 1; // String "0" -> 0 adjacent pairs, ends with 0
        dp[1][0][1] = 1; // String "1" -> 0 adjacent pairs, ends with 1
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                
                // If we append '0' at the i-th position
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                
                // If we append '1' at the i-th position
                long prevZero = dp[i - 1][j][0];
                long prevOne = (j > 0) ? dp[i - 1][j - 1][1] : 0;
                
                dp[i][j][1] = (prevZero + prevOne) % MOD;
            }
        }
        
        // The result is the sum of strings of length n with k pairs ending in 0 or 1
        long result = (dp[n][k][0] + dp[n][k][1]) % MOD;
        
        return (int) result;
    }
}