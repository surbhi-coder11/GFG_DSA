class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        
        // Arrays to store max and min subarray sums from left to right
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        
        // Arrays to store max and min subarray sums from right to left
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];
        
        // Fill leftMax and leftMin using Kadane's Algorithm
        int maxSoFar = arr[0], currentMax = arr[0];
        int minSoFar = arr[0], currentMin = arr[0];
        leftMax[0] = arr[0];
        leftMin[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
            leftMax[i] = maxSoFar;
            
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSoFar = Math.min(minSoFar, currentMin);
            leftMin[i] = minSoFar;
        }
        
        // Fill rightMax and rightMin using Kadane's Algorithm from the right side
        maxSoFar = arr[n - 1]; currentMax = arr[n - 1];
        minSoFar = arr[n - 1]; currentMin = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
            rightMax[i] = maxSoFar;
            
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSoFar = Math.min(minSoFar, currentMin);
            rightMin[i] = minSoFar;
        }
        
        // Find the maximum absolute difference by checking all valid split points
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            // Case 1: Max subarray on left, Min subarray on right
            int absDiff1 = Math.abs(leftMax[i] - rightMin[i + 1]);
            // Case 2: Min subarray on left, Max subarray on right
            int absDiff2 = Math.abs(leftMin[i] - rightMax[i + 1]);
            
            maxDiff = Math.max(maxDiff, Math.max(absDiff1, absDiff2));
        }
        
        return maxDiff;
    }
}