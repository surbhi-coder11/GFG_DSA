class Solution {
    static boolean match(String wild, String pattern) {
        int n = wild.length();
        int m = pattern.length();
        
        // DP table for memoization: Use Integer to represent 3 states
        // null -> unvisited, 1 -> true, 0 -> false
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        
        return solve(n - 1, m - 1, wild, pattern, dp);
    }
    
    private static boolean solve(int i, int j, String wild, String pattern, Boolean[][] dp) {
        // Base Case 1: Both strings are exhausted
        if (i < 0 && j < 0) return true;
        
        // Base Case 2: Wildcard is exhausted but pattern still has characters
        if (i < 0 && j >= 0) return false;
        
        // Base Case 3: Pattern is exhausted but wildcard still has characters
        // Remaining wildcard characters must all be '*' to match an empty pattern
        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (wild.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        
        // Return cached result if already calculated
        if (dp[i][j] != null) return dp[i][j];
        
        // Case 1: Characters match or wild has '?'
        if (wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?') {
            return dp[i][j] = solve(i - 1, j - 1, wild, pattern, dp);
        }
        
        // Case 2: Wild has '*'
        if (wild.charAt(i) == '*') {
            // Two choices: 
            // 1. Act as an empty string -> solve(i - 1, j)
            // 2. Consume one character of pattern -> solve(i, j - 1)
            return dp[i][j] = solve(i - 1, j, wild, pattern, dp) || solve(i, j - 1, wild, pattern, dp);
        }
        
        // Case 3: Characters don't match
        return dp[i][j] = false;
    }
}