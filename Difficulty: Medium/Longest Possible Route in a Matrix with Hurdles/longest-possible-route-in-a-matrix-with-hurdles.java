class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // If either the source or the destination cell is blocked, no path can exist
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        
        return findLongestPath(mat, xs, ys, xd, yd);
    }
    
    private int findLongestPath(int[][] mat, int r, int c, int xd, int yd) {
        // Base Case: Reached the destination cell
        if (r == xd && c == yd) {
            return 0;
        }
        
        // Mark the current cell as visited by setting it to 0
        mat[r][c] = 0;
        
        int maxPath = -1;
        
        // Direction vectors for moving Up, Down, Left, and Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            // Check boundaries and if the cell is traversable (1)
            if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && mat[nr][nc] == 1) {
                int pathLen = findLongestPath(mat, nr, nc, xd, yd);
                
                // If a valid path to the destination was found, update maxPath
                if (pathLen != -1) {
                    maxPath = Math.max(maxPath, 1 + pathLen);
                }
            }
        }
        
        // Backtrack: Unmark the current cell by restoring it back to 1
        mat[r][c] = 1;
        
        return maxPath;
    }
}