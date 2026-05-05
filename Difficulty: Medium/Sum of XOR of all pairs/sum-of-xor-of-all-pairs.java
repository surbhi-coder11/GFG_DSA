class Solution {
    public long sumXOR(int[] arr) {
        long totalSum = 0;
        int n = arr.length;

        // Iterate through each bit position (0 to 31)
        for (int i = 0; i < 32; i++) {
            long count1 = 0; // Count of elements with i-th bit set
            
            for (int j = 0; j < n; j++) {
                // Check if the i-th bit is set
                if ((arr[j] & (1 << i)) != 0) {
                    count1++;
                }
            }
            
            // Elements with i-th bit not set
            long count0 = n - count1;
            
            // Number of pairs with different i-th bits is count1 * count0
            // Contribution to sum = (count1 * count0) * 2^i
            totalSum += (count1 * count0) * (1L << i);
        }

        return totalSum;
    }
}