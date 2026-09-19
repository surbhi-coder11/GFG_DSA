class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] stores the length of LCS of s1[0...i-1] and s2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];

        int deleteCountS1 = m - lcsLength;
        int deleteCountS2 = n - lcsLength;

        return (deleteCountS1 * costS1) + (deleteCountS2 * costS2);
    }
}