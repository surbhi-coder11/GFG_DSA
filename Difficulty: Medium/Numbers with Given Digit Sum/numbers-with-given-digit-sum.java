import java.util.Arrays;

class Solution {
    // Memoization table
    private int[][] memo;

    public int countWays(int n, int sum) {
        // A sum greater than the maximum possible (9 * n) or less than 1 is impossible
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }

        memo = new int[n + 1][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int result = solve(n, sum, true);
        
        // If no such n-digit number exists, return -1
        return result == 0 ? -1 : result;
    }

    private int solve(int digitsLeft, int remainingSum, boolean isFirstDigit) {
        // If we need a negative sum, it's impossible
        if (remainingSum < 0) {
            return 0;
        }

        // Base case: No digits left to place
        if (digitsLeft == 0) {
            return remainingSum == 0 ? 1 : 0;
        }

        // If already computed and not the first digit (to avoid keeping track of 'isFirstDigit' in 2D memo)
        if (!isFirstDigit && memo[digitsLeft][remainingSum] != -1) {
            return memo[digitsLeft][remainingSum];
        }

        int count = 0;
        // First digit must be 1-9; subsequent digits can be 0-9
        int startDigit = isFirstDigit ? 1 : 0;

        for (int digit = startDigit; digit <= 9; digit++) {
            count += solve(digitsLeft - 1, remainingSum - digit, false);
        }

        // Only cache state results that aren't restricted by the "first digit" rule
        if (!isFirstDigit) {
            memo[digitsLeft][remainingSum] = count;
        }

        return count;
    }
}