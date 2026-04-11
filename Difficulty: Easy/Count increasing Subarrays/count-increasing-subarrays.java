class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;

        int totalCount = 0;
        int len = 1; // Length of the current increasing segment

        for (int i = 0; i < n - 1; i++) {
            // Check if the next element continues the increasing sequence
            if (arr[i + 1] > arr[i]) {
                len++;
            } else {
                // If the sequence breaks, calculate subarrays for the finished segment
                if (len >= 2) {
                    totalCount += (len * (len - 1)) / 2;
                }
                len = 1; // Reset length for the next potential segment
            }
        }

        // Final check for the last segment in the array
        if (len >= 2) {
            totalCount += (len * (len - 1)) / 2;
        }

        return totalCount;
    }
}