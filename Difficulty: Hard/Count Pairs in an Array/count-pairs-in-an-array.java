import java.util.List;
import java.util.ArrayList;

class Solution {
    public int countPairs(List<Integer> arr) {
        int n = arr.size();
        // Step 1: Transform the array to stores i * arr[i]
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = i * arr.get(i);
        }
        
        // Step 2: Count inversions using Merge Sort
        return mergeSortAndCount(transformed, 0, n - 1);
    }
    
    private int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            
            // Total inversions = left subarray + right subarray + merge split inversions
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }
    
    private int mergeAndCount(int[] arr, int l, int m, int r) {
        // Left and right subarrays
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[m + 1 + i];
        }
        
        int i = 0, j = 0, k = l;
        int swaps = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                // If left[i] > right[j], then all remaining elements 
                // from left[i] to left[left.length - 1] will be greater than right[j]
                swaps += (left.length - i);
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        
        return swaps;
    }
}