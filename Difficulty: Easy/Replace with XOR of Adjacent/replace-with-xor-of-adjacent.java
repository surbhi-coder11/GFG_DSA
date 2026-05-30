class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        
        // Edge case: constraint says 2 <= n <= 10^5, 
        // but it's good practice to handle small arrays.
        if (n < 2) return;

        // Store the original first element before modifying it
        int prev = arr[0];

        // 1. Update the first element: arr[0] = arr[0] ^ arr[1]
        arr[0] = arr[0] ^ arr[1];

        // 2. Update the middle elements from index 1 to n-2
        for (int i = 1; i < n - 1; i++) {
            int currentOriginal = arr[i]; // Keep track of the current element's original value
            
            // arr[i] becomes (XOR of original arr[i-1] and original arr[i+1])
            arr[i] = prev ^ arr[i + 1];
            
            // Move the current original value to 'prev' for the next iteration
            prev = currentOriginal;
        }

        // 3. Update the last element: arr[n-1] = arr[n-2] (which is 'prev') ^ arr[n-1]
        arr[n - 1] = prev ^ arr[n - 1];
    }
}