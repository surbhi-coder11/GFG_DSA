class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;

        // DP state representing the minimum cost up to the current row for choices 0, 1, and 2
        int prev0 = mat[0][0];
        int prev1 = mat[0][1];
        int prev2 = mat[0][2];

        for (int i = 1; i < n; i++) {
            // For choice 0 at row i, pick min cost from prev choices 1 or 2
            int curr0 = mat[i][0] + Math.min(prev1, prev2);
            // For choice 1 at row i, pick min cost from prev choices 0 or 2
            int curr1 = mat[i][1] + Math.min(prev0, prev2);
            // For choice 2 at row i, pick min cost from prev choices 0 or 1
            int curr2 = mat[i][2] + Math.min(prev0, prev1);

            // Update state for next iteration
            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
        }

        // The answer is the minimum among all three choices at the last row
        return Math.min(prev0, Math.min(prev1, prev2));
    }
}