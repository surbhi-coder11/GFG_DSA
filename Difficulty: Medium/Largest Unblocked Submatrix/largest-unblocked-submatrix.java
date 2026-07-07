import java.util.Arrays;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        int k = arr.length;
        
        // Arrays to store blocked rows and columns including boundaries
        int[] rows = new int[k + 2];
        int[] cols = new int[k + 2];
        
        // 1-based indexing boundaries
        rows[0] = 0;
        rows[k + 1] = n + 1;
        
        cols[0] = 0;
        cols[k + 1] = m + 1;
        
        for (int i = 0; i < k; i++) {
            rows[i + 1] = arr[i][0];
            cols[i + 1] = arr[i][1];
        }
        
        // Sort to find consecutive segments
        Arrays.sort(rows);
        Arrays.sort(cols);
        
        // Find the max consecutive unblocked row gap
        int maxRowGap = 0;
        for (int i = 1; i < rows.length; i++) {
            maxRowGap = Math.max(maxRowGap, rows[i] - rows[i - 1] - 1);
        }
        
        // Find the max consecutive unblocked column gap
        int maxColGap = 0;
        for (int i = 1; i < cols.length; i++) {
            maxColGap = Math.max(maxColGap, cols[i] - cols[i - 1] - 1);
        }
        
        // The maximum submatrix area is the product of the maximum gaps
        return maxRowGap * maxColGap;
    }
}