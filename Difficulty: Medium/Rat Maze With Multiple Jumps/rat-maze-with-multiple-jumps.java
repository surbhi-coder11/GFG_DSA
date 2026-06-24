import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        
        // Initialize the solution matrix with 0s
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }
        
        // visited[i][j] will be true if we already know (i, j) cannot reach the destination
        boolean[][] visited = new boolean[n][n];
        
        // Start backtracking from the top-left cell (0, 0)
        if (solveMaze(0, 0, mat, ans, n, visited)) {
            return ans;
        }
        
        // If no valid path is found, return [[-1]]
        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> failRow = new ArrayList<>();
        failRow.add(-1);
        noPath.add(failRow);
        return noPath;
    }
    
    private boolean solveMaze(int r, int c, int[][] mat, ArrayList<ArrayList<Integer>> ans, int n, boolean[][] visited) {
        // Base case: If destination (n-1, n-1) is reached
        if (r == n - 1 && c == n - 1) {
            ans.get(r).set(c, 1);
            return true;
        }
        
        // Check bounds, blocking, and if this cell is already a known dead-end
        if (r >= 0 && r < n && c >= 0 && c < n && mat[r][c] != 0 && !visited[r][c]) {
            
            // Mark the current cell as part of the solution path
            ans.get(r).set(c, 1);
            
            int maxJumps = mat[r][c];
            
            // Try jumps from 1 to maxJumps (Shortest jump first)
            for (int jump = 1; jump <= maxJumps; jump++) {
                
                // 1. Try moving Right first (Column increases)
                if (solveMaze(r, c + jump, mat, ans, n, visited)) {
                    return true;
                }
                
                // 2. Try moving Down next (Row increases)
                if (solveMaze(r + jump, c, mat, ans, n, visited)) {
                    return true;
                }
            }
            
            // Backtrack: If none of the jumps lead to a solution, unmark this cell
            ans.get(r).set(c, 0);
            
            // MEMOIZATION: Mark this cell as a dead-end so we never waste time recalculating it
            visited[r][c] = true;
        }
        
        return false;
    }
}