import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        long currentSum = 0;
        int n = arr.length;

        for (int end = 0; end < n; end++) {
            // Add the current element to the window
            currentSum += arr[end];

            // If currentSum exceeds the target, shrink the window from the left
            while (currentSum > target && start < end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if we found the target sum
            if (currentSum == target) {
                result.add(start + 1); // 1-based indexing
                result.add(end + 1);   // 1-based indexing
                return result;
            }
        }

        // If no subarray is found
        result.add(-1);
        return result;
    }
}