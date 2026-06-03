import java.util.Arrays;

class Solution {
    public static String betterString(String s1, String s2) {
        // Count distinct subsequences for both strings
        int count1 = countDistinctSubsequences(s1);
        int count2 = countDistinctSubsequences(s2);
        
        // If s1 has more or equal distinct subsequences, return s1
        if (count1 >= count2) {
            return s1;
        } else {
            return s2;
        }
    }
    
    private static int countDistinctSubsequences(String s) {
        int n = s.length();
        
        // dp[i] stores the number of distinct subsequences of substring s[0...i-1]
        int[] dp = new int[n + 1];
        
        // Base case: An empty string has 1 subsequence (the empty string itself)
        dp[0] = 1;
        
        // Array to store the last occurrence index of each character
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            
            // Double the count of subsequences from the previous step
            dp[i] = 2 * dp[i - 1];
            
            // If the character has appeared before, subtract the duplicates
            if (lastSeen[ch] != -1) {
                int prevIndex = lastSeen[ch];
                dp[i] = dp[i] - dp[prevIndex];
            }
            
            // Update the last seen position of the current character
            lastSeen[ch] = i - 1;
        }
        
        return dp[n];
    }
}