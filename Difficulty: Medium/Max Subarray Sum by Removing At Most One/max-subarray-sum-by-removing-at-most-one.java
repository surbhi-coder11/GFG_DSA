class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        
        // Handle base case where array has only one element
        if (n == 1) {
            return arr[0];
        }

        // fw[i] stores the maximum subarray sum ending at index i
        int[] fw = new int[n];
        // bw[i] stores the maximum subarray sum starting at index i
        int[] bw = new int[n];

        // Initialize forward Kadane
        fw[0] = arr[0];
        int max_so_far = arr[0];
        for (int i = 1; i < n; i++) {
            fw[i] = Math.max(arr[i], fw[i - 1] + arr[i]);
            max_so_far = Math.max(max_so_far, fw[i]);
        }

        // Initialize backward Kadane
        bw[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            bw[i] = Math.max(arr[i], bw[i + 1] + arr[i]);
        }

        // Choose the maximum sum by removing at most one element
        // We start from index 1 to n-2 because removing endpoints is already covered by standard Kadane
        for (int i = 1; i < n - 1; i++) {
            max_so_far = Math.max(max_so_far, fw[i - 1] + bw[i + 1]);
        }

        return max_so_far;
    }
}