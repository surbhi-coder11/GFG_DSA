class Solution {
    public boolean canSplit(int arr[]) {
        long totalSum = 0;
        
        // Step 1: Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // Step 2: If total sum is odd, it cannot be split into two equal integers
        // This is a quick optimization, though not strictly necessary if 
        // using the prefix sum logic below.
        if (totalSum % 2 != 0) {
            return false;
        }
        
        long prefixSum = 0;
        
        // Step 3: Iterate and check for the split point
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            // If current left sum equals the remaining right sum
            if (prefixSum == totalSum - prefixSum) {
                return true;
            }
        }
        
        return false;
    }
}