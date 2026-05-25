class Solution {
    public long maxSumWithK(long a[], long n, long k) {
        // Step 1: Compute the sum of the first 'k' elements
        long currentWindowSum = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += a[i];
        }

        // Initialize max operations with the first window sum
        long maxSubarraySum = currentWindowSum;

        // 'slidingPrefixSum' tracks the sum of elements that can be appended before the current window
        long slidingPrefixSum = 0; 
        
        // Pointer to track the element falling off the back of the prefix window
        int prefixIndex = 0; 

        // Step 2: Slide the window of size k from index k to n-1
        for (int i = (int)k; i < n; i++) {
            // Add the new element to the current window and remove the oldest element
            currentWindowSum += a[i] - a[i - (int)k];

            // Update the prefix sum with the element that just left the 'k' window
            slidingPrefixSum += a[prefixIndex++];

            // If the prefix sum becomes negative, it's a drag. Reset it to 0 (Kadane's concept).
            if (slidingPrefixSum < 0) {
                slidingPrefixSum = 0;
            }

            // The potential max sum is either the window itself, or the window + positive prefix elements
            long totalPossibleSum = currentWindowSum + slidingPrefixSum;
            maxSubarraySum = Math.max(maxSubarraySum, totalPossibleSum);
        }

        return maxSubarraySum;
    }
}