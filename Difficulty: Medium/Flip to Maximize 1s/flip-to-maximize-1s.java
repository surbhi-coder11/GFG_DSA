class Solution {
    public int maxOnes(int[] arr) {
        int totalOnes = 0;
        int maxGain = 0;
        int currentGain = 0;

        for (int val : arr) {
            // Step 1: Count initial 1s
            if (val == 1) {
                totalOnes++;
            }

            // Step 2 & 3: Apply Kadane's logic
            // Flip 0 -> gain is 1 | Flip 1 -> gain is -1
            int gainValue = (val == 0) ? 1 : -1;
            
            currentGain += gainValue;
            
            // If current gain becomes negative, reset to 0 
            // (equivalent to starting a new subarray)
            if (currentGain < 0) {
                currentGain = 0;
            }
            
            // Track the highest gain found so far
            if (currentGain > maxGain) {
                maxGain = currentGain;
            }
        }

        return totalOnes + maxGain;
    }
}