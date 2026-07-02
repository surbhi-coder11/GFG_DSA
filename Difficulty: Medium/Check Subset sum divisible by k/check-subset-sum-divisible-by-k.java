class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        // If k is 1, any positive integer sum is divisible by 1
        if (k == 1) return true;
        
        // dp[i] will be true if a subset sum with remainder 'i' is possible
        boolean[] dp = new boolean[k];
        
        for (int num : arr) {
            // Find the remainder of the current element
            int rem = num % k;
            
            // If the element itself is divisible by k, we found a valid subset
            if (rem == 0) return true;
            
            // To avoid using the current element multiple times in the same step,
            // we use a temporary array to store new reachable remainders
            boolean[] nextDp = dp.clone();
            
            // The current remainder itself is reachable by a single-element subset
            nextDp[rem] = true;
            
            // Check all previously reachable remainders
            for (int i = 0; i < k; i++) {
                if (dp[i]) {
                    int newRem = (i + rem) % k;
                    if (newRem == 0) {
                        return true; // Found a subset sum divisible by k
                    }
                    nextDp[newRem] = true;
                }
            }
            
            // Update the main dp array for the next iteration
            dp = nextDp;
        }
        
        return dp[0];
    }
}