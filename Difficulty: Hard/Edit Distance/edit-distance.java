class Solution {
    public int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // dp[i][j] will store the minimum operations to convert 
        // s1[0...i-1] to s2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base Cases: 
        // If s2 is empty, we must remove all characters from s1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // If s1 is empty, we must insert all characters of s2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, no new operation is needed
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If characters mismatch, consider all 3 operations:
                    // 1. dp[i][j-1]   -> Insert
                    // 2. dp[i-1][j]   -> Remove
                    // 3. dp[i-1][j-1] -> Replace
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], 
                                   Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
}