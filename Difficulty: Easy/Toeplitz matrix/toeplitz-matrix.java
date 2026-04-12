class Solution {
    public boolean isToeplitz(int[][] mat) {
        // Get dimensions of the matrix
        int rows = mat.length;
        int cols = mat[0].length;

        // Iterate through each cell starting from the second row and second column
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // If current element is not equal to its top-left neighbor
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        // If the loop completes, all diagonals are constant
        return true;
    }
}