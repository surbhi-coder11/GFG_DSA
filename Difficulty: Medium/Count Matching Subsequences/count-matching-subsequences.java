class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int MOD = 1_000_000_007;

        // dp[j] stores the count of subsequences of s2[0...j-1]
        int[] dp = new int[m + 1];
        
        // Base case: empty s2 has 1 subsequence in any prefix of s1
        dp[0] = 1;

        // Traverse through s1
        for (int i = 0; i < n; i++) {
            // Traverse s2 backwards to use values from the previous iteration of s1
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i) == s2.charAt(j - 1)) {
                    dp[j] = (dp[j] + dp[j - 1]) % MOD;
                }
            }
        }

        return dp[m];
    }
}