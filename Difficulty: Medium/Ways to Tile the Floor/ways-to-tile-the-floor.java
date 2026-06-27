class Solution {
    public int countWays(int n, int m) {
        // Base case: if floor width is less than m, we can only place tiles vertically
        if (n < m) {
            return 1;
        }
        // If floor width is equal to m, we can either place all vertically or all horizontally
        if (n == m) {
            return 2;
        }

        int MOD = 1000000007;
        int[] dp = new int[n + 1];

        // Initialize base cases
        for (int i = 1; i < m; i++) {
            dp[i] = 1;
        }
        dp[m] = 2;

        // Fill the DP table using the recurrence relation
        for (int i = m + 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - m]) % MOD;
        }

        return dp[n];
    }
}