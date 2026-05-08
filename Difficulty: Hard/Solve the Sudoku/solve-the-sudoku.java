class Solution {
    public void solveSudoku(int[][] mat) {
        solve(mat);
    }

    private boolean solve(int[][] mat) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                
                // Look for an empty cell (represented by 0)
                if (mat[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(mat, row, col, num)) {
                            mat[row][col] = num;

                            // Recurse to see if this leads to a solution
                            if (solve(mat)) {
                                return true;
                            }

                            // Backtrack if the choice wasn't correct
                            mat[row][col] = 0;
                        }
                    }
                    // If no number 1-9 works in this cell, return false
                    return false;
                }
            }
        }
        return true; // All cells filled correctly
    }

    private boolean isValid(int[][] mat, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (mat[row][i] == num) return false;
            
            // Check column
            if (mat[i][col] == num) return false;
            
            // Check 3x3 sub-grid
            // (row / 3) * 3 gives the starting row index of the box
            // (col / 3) * 3 gives the starting col index of the box
            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }
        return true;
    }
}