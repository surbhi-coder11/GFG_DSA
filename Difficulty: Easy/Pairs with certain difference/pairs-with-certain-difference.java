import java.util.Arrays;

class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);
        
        int maxSum = 0;
        int i = arr.length - 1; // Start from the largest element
        
        // Step 2: Iterate from right to left to pick the largest possible valid pairs
        while (i > 0) {
            // Check if the difference between adjacent elements is less than k
            if (arr[i] - arr[i - 1] < k) {
                maxSum += arr[i] + arr[i - 1];
                i -= 2; // Move past this disjoint pair
            } else {
                i--; // Move to the next element to try and find a pair
            }
        }
        
        return maxSum;
    }
}