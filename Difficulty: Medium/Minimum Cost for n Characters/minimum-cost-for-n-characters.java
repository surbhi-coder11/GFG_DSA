class Solution {
    public static long minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int len = 1; len <= n; len++) {
            // Option 1: Insert 1 character
            dp[len] = dp[len - 1] + i;

            // Option 2: Double the string if even, or double and delete if odd
            if (len % 2 == 0) {
                dp[len] = Math.min(dp[len], dp[len / 2] + c);
            } else {
                // To get length 'len', double ((len + 1) / 2) and delete 1 character
                dp[len] = Math.min(dp[len], dp[(len + 1) / 2] + c + d);
            }
        }

        return dp[n];
    }
}