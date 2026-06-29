class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        // dp[i][j] stores the maximum dot product of first i elements of a and first j elements of b
        int[][] dp = new int[n + 1][m + 1];
        
        // Loop through both arrays
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If there are fewer elements in a than b, it's an invalid state
                if (i < j) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // Choice 1: Match a[i-1] with b[j-1]
                int match = dp[i - 1][j - 1] + (a[i - 1] * b[j - 1]);
                
                // Choice 2: Skip a[i-1] (multiply with 0)
                int skip = dp[i - 1][j];
                
                // Take the maximum of both choices
                dp[i][j] = Math.max(match, skip);
            }
        }
        
        return dp[n][m];
    }
}