import java.util.Arrays;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        // Sort first half and second half independently
        Arrays.sort(arr, 0, mid);
        Arrays.sort(arr, mid, n);

        int count = 0;
        int j = mid;

        // For each element in the left half, find valid elements in the right half
        for (int i = 0; i < mid; i++) {
            while (j < n && arr[i] >= 5 * arr[j]) {
                j++;
            }
            // All elements from index 'mid' up to 'j - 1' satisfy the condition
            count += (j - mid);
        }

        return count;
    }
}