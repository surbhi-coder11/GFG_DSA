import java.util.ArrayList;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        // If m >= n, the bird can visit all trees
        if (m >= n) {
            int totalSum = 0;
            for (int fruits : arr) {
                totalSum += fruits;
            }
            return totalSum;
        }

        // Calculate the sum of the first window of size m
        int currentSum = 0;
        for (int i = 0; i < m; i++) {
            currentSum += arr.get(i);
        }

        int maxSum = currentSum;

        // Slide the window across the circular array
        for (int i = 1; i < n; i++) {
            // Subtract element leaving the window and add element entering the window
            currentSum = currentSum - arr.get(i - 1) + arr.get((i + m - 1) % n);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}