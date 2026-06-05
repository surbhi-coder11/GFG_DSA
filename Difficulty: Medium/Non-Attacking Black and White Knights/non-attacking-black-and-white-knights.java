class Solution {
    public long numOfWays(int n, int m) {
        long totalSquares = (long) n * m;
        
        // Total ways to choose 2 distinct squares for 2 distinct knights
        long totalWays = totalSquares * (totalSquares - 1);
        
        // Count attacking pairs
        long attackingWays = 0;
        
        // 2x3 sub-grids
        if (n >= 2 && m >= 3) {
            attackingWays += 4L * (n - 1) * (m - 2);
        }
        
        // 3x2 sub-grids
        if (n >= 3 && m >= 2) {
            attackingWays += 4L * (n - 2) * (m - 1);
        }
        
        // Non-attacking configurations
        return totalWays - attackingWays;
    }
}