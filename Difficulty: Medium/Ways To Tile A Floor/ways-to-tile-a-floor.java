class Solution {
    public int numberOfWays(int n) {
        // Base cases
        if (n <= 1) return 1;
        
        // table to store results of subproblems
        int[] dp = new int[n + 1];
        
        // Initializing base values
        dp[0] = 1;
        dp[1] = 1;
        
        // Fill the table in iterative manner
        for (int i = 2; i <= n; i++) {
            // Relation: ways(i) = ways(i-1) + ways(i-2)
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}