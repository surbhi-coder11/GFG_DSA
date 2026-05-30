class Solution {
    public boolean isSumOfConsecutive(int n) {
        // Base case: 1 cannot be expressed as a sum of 2 or more positive consecutive numbers
        if (n <= 1) {
            return false;
        }
        
        // If n is a power of 2, (n & (n - 1)) will be 0.
        // We return true if it is NOT a power of 2.
        return (n & (n - 1)) != 0;
    }
}