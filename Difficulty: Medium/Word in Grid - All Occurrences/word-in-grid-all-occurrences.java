import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        // 8 possible directions: {row_change, col_change}
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Iterate through every cell in row-major order (ensures lexicographical order)
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == word.charAt(0)) {
                    // Check all 8 directions from the starting cell
                    for (int dir = 0; dir < 8; dir++) {
                        if (checkDirection(mat, word, r, c, dx[dir], dy[dir])) {
                            ArrayList<Integer> coord = new ArrayList<>();
                            coord.add(r);
                            coord.add(c);
                            result.add(coord);
                            break; // Stop checking other directions for this cell to avoid duplicates
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean checkDirection(char[][] mat, String word, int r, int c, int dr, int dc) {
        int len = word.length();
        int n = mat.length;
        int m = mat[0].length;

        for (int k = 0; k < len; k++) {
            int newRow = r + k * dr;
            int newCol = c + k * dc;

            // Check boundary conditions and character match
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || mat[newRow][newCol] != word.charAt(k)) {
                return false;
            }
        }

        return true;
    }
}