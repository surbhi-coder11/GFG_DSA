class Solution {
    public int getCount(int n) {
        int count = 0;
        
        // k represents the number of consecutive elements (must be >= 2)
        for (int k = 2; (k * (k - 1)) / 2 < n; k++) {
            long sumOfK = (long) k * (k - 1) / 2;
            
            // Check if remaining value is perfectly divisible by k
            if ((n - sumOfK) % k == 0) {
                count++;
            }
        }
        
        return count;
    }
}