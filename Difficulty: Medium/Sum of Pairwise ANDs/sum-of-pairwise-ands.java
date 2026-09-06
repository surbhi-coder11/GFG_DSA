class Solution {
    public static long pairAndSum(int arr[]) {
        int n = arr.length;
        long totalSum = 0;

        // Iterate through all 32 bits
        for (int i = 0; i < 32; i++) {
            long countSetBits = 0;

            // Count how many numbers have the i-th bit set
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    countSetBits++;
                }
            }

            // Number of valid pairs for the i-th bit is C(countSetBits, 2)
            long pairs = (countSetBits * (countSetBits - 1)) / 2;

            // Add the contribution of the i-th bit to the sum
            totalSum += pairs * (1L << i);
        }

        return totalSum;
    }
}