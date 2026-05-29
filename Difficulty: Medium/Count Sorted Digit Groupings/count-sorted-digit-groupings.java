import java.util.Arrays;

class Solution {
    // Maximum possible sum for a string of length 100 is 100 * 9 = 900
    private int[][] dp;

    public int validGroups(String s) {
        int n = s.length();
        
        // dp[index][previousSum]
        // index can go up to 100, previousSum can go up to 900
        dp = new int[n][901];
        
        // Initialize DP table with -1 to indicate unvisited states
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countGroupings(0, 0, s);
    }

    private int countGroupings(int index, int previousSum, String s) {
        // Base case: If we reach the end of the string, we found a valid grouping
        if (index == s.length()) {
            return 1;
        }

        // Return cached result if it exists
        if (dp[index][previousSum] != -1) {
            return dp[index][previousSum];
        }

        int currentSum = 0;
        int totalWays = 0;

        // Try to form all possible contiguous substrings starting from 'index'
        for (int i = index; i < s.length(); i++) {
            currentSum += s.charAt(i) - '0';

            // The grouping is valid only if the current sum >= previous sum
            if (currentSum >= previousSum) {
                totalWays += countGroupings(i + 1, currentSum, s);
            }
        }

        // Cache and return the result
        return dp[index][previousSum] = totalWays;
    }
}