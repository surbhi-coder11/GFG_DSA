class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = mat.length;

        // The number of anti-diagonals is 2n - 1
        // The sum of indices (i + j) ranges from 0 to 2n - 2
        for (int sum = 0; sum <= 2 * (n - 1); sum++) {
            
            // For a fixed sum, we find the starting row 'i'
            // Since i + j = sum, then j = sum - i
            // Constraints: 0 <= i < n and 0 <= j < n
            // Substituting j: 0 <= sum - i < n  =>  sum - n < i <= sum
            
            int startRow = Math.max(0, sum - (n - 1));
            int endRow = Math.min(sum, n - 1);

            for (int i = startRow; i <= endRow; i++) {
                int j = sum - i;
                result.add(mat[i][j]);
            }
        }
        return result;
    }
}
