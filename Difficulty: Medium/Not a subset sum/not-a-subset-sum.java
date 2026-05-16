import java.util.Arrays;

class Solution {
    public int findSmallest(int[] arr) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);
        
        // Step 2: Initialize the smallest positive integer we cannot form
        int res = 1;
        
        // Step 3: Iterate through the sorted array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is greater than 'res', 
            // 'res' cannot be formed by any subset.
            if (arr[i] > res) {
                break;
            }
            
            // Otherwise, add the current element to 'res' to expand the reachable range
            res += arr[i];
        }
        
        return res;
    }
}