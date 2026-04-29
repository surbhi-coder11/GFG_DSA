class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int totalOnes = 0;

        // Step 1: Count total number of 1s in the array
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                totalOnes++;
            }
        }

        // Edge Case: If there are no 1s, return -1 as per problem statement
        if (totalOnes == 0) return -1;

        // Step 2: Use a sliding window of size 'totalOnes'
        int currentOnesInWindow = 0;
        int maxOnesInWindow = 0;

        // Initial window (first 'totalOnes' elements)
        for (int i = 0; i < totalOnes; i++) {
            if (arr[i] == 1) {
                currentOnesInWindow++;
            }
        }
        
        maxOnesInWindow = currentOnesInWindow;

        // Slide the window across the rest of the array
        for (int i = totalOnes; i < n; i++) {
            // Add the new element entering the window
            if (arr[i] == 1) {
                currentOnesInWindow++;
            }
            // Remove the element leaving the window
            if (arr[i - totalOnes] == 1) {
                currentOnesInWindow--;
            }
            
            // Update the maximum 1s found in any window
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }

        // The minimum swaps = (Window Size) - (Max 1s already in a window)
        return totalOnes - maxOnesInWindow;
    }
}