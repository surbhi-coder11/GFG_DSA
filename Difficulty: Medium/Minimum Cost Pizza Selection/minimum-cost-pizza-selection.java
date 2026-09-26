class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // dp[i] will store the minimum cost to get at least 'i' units of pizza area
        int[] dp = new int[x + 1];

        for (int i = 1; i <= x; i++) {
            // Option 1: Buy Small Pizza
            int costSmall = cs + (i - s > 0 ? dp[i - s] : 0);

            // Option 2: Buy Medium Pizza
            int costMedium = cm + (i - m > 0 ? dp[i - m] : 0);

            // Option 3: Buy Large Pizza
            int costLarge = cl + (i - l > 0 ? dp[i - l] : 0);

            // Take the minimum cost among all 3 choices
            dp[i] = Math.min(costSmall, Math.min(costMedium, costLarge));
        }

        return dp[x];
    }
}