class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        // code here
        if (n < k) return 0;
        
        int currentXor = 0;
        
        // First window
        for (int i = 0; i < k; i++) {
            currentXor ^= arr[i];
        }
        
        int maxXor = currentXor;
        
        // Slide window
        for (int i = k; i < n; i++) {
            currentXor ^= arr[i - k];  // remove left element
            currentXor ^= arr[i];      // add new element
            
            maxXor = Math.max(maxXor, currentXor);
        }
        
        return maxXor;
    }
}
