import java.util.Arrays;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Step 1: Compute consecutive 1s for each position in columns
        int[][] hist = new int[n][m];

        for (int j = 0; j < m; j++) {
            hist[0][j] = mat[0][j];
            for (int i = 1; i < n; i++) {
                hist[i][j] = (mat[i][j] == 0) ? 0 : hist[i - 1][j] + 1;
            }
        }

        int maxArea = 0;

        // Step 2: For each row, sort heights in non-increasing order and calculate max area
        for (int i = 0; i < n; i++) {
            int[] count = new int[n + 1];

            // Count frequencies of height values (Counting Sort approach for O(M) time)
            for (int j = 0; j < m; j++) {
                count[hist[i][j]]++;
            }

            // Reconstruct heights in descending order
            int colIdx = 0;
            for (int height = n; height >= 0; height--) {
                while (count[height] > 0) {
                    hist[i][colIdx++] = height;
                    count[height]--;
                }
            }

            // Calculate area assuming columns are sorted
            for (int j = 0; j < m; j++) {
                int area = hist[i][j] * (j + 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}