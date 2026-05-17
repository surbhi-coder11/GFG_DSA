
class Solution {
    public int maxSum(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return n;
        }
        
        // DP array to store max sum for each value up to n
        int[] dp = new int[n + 1];
        
        // Base conditions for DP
        dp[0] = 0;
        dp[1] = 1;
        
        // Fill the DP table iteratively
        for (int i = 2; i <= n; i++) {
            // Option 1: Don't break the number
            int noBreak = i;
            
            // Option 2: Sum of the 3 recursively broken parts
            int breakDown = dp[i / 2] + dp[i / 3] + dp[i / 4];
            
            // Store the maximum of both choices
            dp[i] = Math.max(noBreak, breakDown);
        }
        
        return dp[n];
    }
}