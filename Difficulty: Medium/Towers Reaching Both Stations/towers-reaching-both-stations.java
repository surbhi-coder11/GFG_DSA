class Solution {
    public int countCoordinates(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] reachableP = new boolean[n][m];
        boolean[][] reachableQ = new boolean[n][m];
        
        // Rows and Columns traversal setup
        // Top and Bottom rows
        for (int j = 0; j < m; j++) {
            dfs(0, j, mat, reachableP, mat[0][j]);     // Station P (Top boundary)
            dfs(n - 1, j, mat, reachableQ, mat[n - 1][j]); // Station Q (Bottom boundary)
        }
        
        // Left and Right columns
        for (int i = 0; i < n; i++) {
            dfs(i, 0, mat, reachableP, mat[i][0]);     // Station P (Left boundary)
            dfs(i, m - 1, mat, reachableQ, mat[i][m - 1]); // Station Q (Right boundary)
        }
        
        // Count coordinates that can reach both stations
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (reachableP[i][j] && reachableQ[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int r, int c, int[][] mat, boolean[][] visited, int prevHeight) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Boundary check, visited check, and height/signal strength check
        if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || mat[r][c] < prevHeight) {
            return;
        }
        
        visited[r][c] = true;
        
        // Explore all 4 directions (North, South, East, West)
        dfs(r + 1, c, mat, visited, mat[r][c]);
        dfs(r - 1, c, mat, visited, mat[r][c]);
        dfs(r, c + 1, mat, visited, mat[r][c]);
        dfs(r, c - 1, mat, visited, mat[r][c]);
    }
}