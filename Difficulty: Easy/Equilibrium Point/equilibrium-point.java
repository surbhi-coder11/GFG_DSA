class Solution {
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0;
        int leftSum = 0;

        // Step 1: Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Iterate to find the equilibrium point
        for (int i = 0; i < arr.length; i++) {
            // Calculate right sum based on total and current left sum
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i; // Found the first equilibrium index
            }

            // Update left sum for the next iteration
            leftSum += arr[i];
        }

        // Return -1 if no equilibrium point is found
        return -1;
    }
}