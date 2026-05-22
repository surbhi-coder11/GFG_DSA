class Solution {
    int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Traverse the boundary rows (first and last row)
        for (int j = 0; j < m; j++) {
            // First row
            if (grid[0][j] == 1) {
                dfs(grid, 0, j, n, m);
            }
            // Last row
            if (grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j, n, m);
            }
        }
        
        // Step 2: Traverse the boundary columns (first and last column)
        for (int i = 0; i < n; i++) {
            // First column
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, n, m);
            }
            // Last column
            if (grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1, n, m);
            }
        }
        
        // Step 3: Count the remaining 1s which couldn't reach the boundary
        int trappedOnes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    trappedOnes++;
                }
            }
        }
        
        return trappedOnes;
    }
    
    // Helper method to perform DFS and mark connected 1s as visited (0)
    private void dfs(int[][] grid, int r, int c, int n, int m) {
        // Base case: check boundary limits and if the cell is already 0
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) {
            return;
        }
        
        // Mark the current cell as 0 so we don't revisit it
        grid[r][c] = 0;
        
        // Explore all 4 adjacent directions
        dfs(grid, r - 1, c, n, m); // Up
        dfs(grid, r + 1, c, n, m); // Down
        dfs(grid, r, c - 1, n, m); // Left
        dfs(grid, r, c + 1, n, m); // Right
    }
}