class Solution {
    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int MOD = 1000000007;

        // count[r][c] stores the number of 1s in the submatrix from (r, c) to (n-1, m-1)
        int[][] count = new int[n + 1][m + 1];
        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {
                count[r][c] = matrix[r][c] + count[r + 1][c] + count[r][c + 1] - count[r + 1][c + 1];
            }
        }

        // dp[r][c] stores the number of ways to divide the submatrix starting at (r, c) into 'rem' pieces
        int[][] dp = new int[n][m];

        // Suffix sums of dp to optimize transitions to O(1)
        int[][] rowSum = new int[n + 1][m + 1];
        int[][] colSum = new int[n + 1][m + 1];

        // Base case: rem = 1 piece remaining
        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {
                dp[r][c] = count[r][c] > 0 ? 1 : 0;
                rowSum[r][c] = (dp[r][c] + rowSum[r + 1][c]) % MOD;
                colSum[r][c] = (dp[r][c] + colSum[r][c + 1]) % MOD;
            }
        }

        // DP for pieces from 2 to k
        for (int rem = 2; rem <= k; rem++) {
            int[][] nextDp = new int[n][m];
            int[][] nextRowSum = new int[n + 1][m + 1];
            int[][] nextColSum = new int[n + 1][m + 1];

            for (int r = n - 1; r >= 0; r--) {
                for (int c = m - 1; c >= 0; c--) {
                    if (count[r][c] < rem) {
                        // Not enough 1s left to form the remaining pieces
                        continue; 
                    }

                    long ways = 0;

                    // 1. Horizontal cuts: find the first row `i+1` where count[r][c] > count[i+1][c]
                    // Since it's monotonic, we can binary search or find it lineary.
                    // To keep O(1) transition, find the boundary:
                    int nextRow = r + 1;
                    while (nextRow < n && count[r][c] == count[nextRow][c]) {
                        nextRow++;
                    }
                    if (nextRow < n) {
                        ways = (ways + rowSum[nextRow][c]) % MOD;
                    }

                    // 2. Vertical cuts: find the first col `j+1` where count[r][c] > count[r][j+1]
                    int nextCol = c + 1;
                    while (nextCol < m && count[r][c] == count[r][nextCol]) {
                        nextCol++;
                    }
                    if (nextCol < m) {
                        ways = (ways + colSum[r][nextCol]) % MOD;
                    }

                    nextDp[r][c] = (int) ways;
                    nextRowSum[r][c] = (nextDp[r][c] + nextRowSum[r + 1][c]) % MOD;
                    nextColSum[r][c] = (nextDp[r][c] + nextColSum[r][c + 1]) % MOD;
                }
            }
            dp = nextDp;
            rowSum = nextRowSum;
            colSum = nextColSum;
        }

        return dp[0][0];
    }
}