import java.util.Arrays;

class Solution {
    public int minimumCost(int cost[], int w) {
        // dp[i] will store the minimum cost to get exactly 'i' kg of oranges
        int[] dp = new int[w + 1];
        
        // Initialize the array with a large value representing infinity
        // We use Integer.MAX_VALUE / 2 to prevent integer overflow when adding costs
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        
        // Base case: 0 kg costs 0
        dp[0] = 0;
        
        // Traverse through all packet sizes from 1 to cost.length
        for (int i = 0; i < cost.length; i++) {
            // Skip if the current packet size is unavailable
            if (cost[i] == -1) {
                continue;
            }
            
            int packetWeight = i + 1;
            int packetCost = cost[i];
            
            // Update the DP array for all weights from 'packetWeight' up to 'w'
            for (int j = packetWeight; j <= w; j++) {
                dp[j] = Math.min(dp[j], dp[j - packetWeight] + packetCost);
            }
        }
        
        // If dp[w] is still the large initial value, it means exact weight 'w' cannot be formed
        return dp[w] >= Integer.MAX_VALUE / 2 ? -1 : dp[w];
    }
}