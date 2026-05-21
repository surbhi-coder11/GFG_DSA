class Solution {
    public boolean isBitSet(int n) {
        if (n == 0) {
            return false;
        }
        
        while (n > 0) {
            // If the last bit is not 1, then all bits are not set
            if ((n & 1) == 0) {
                return false;
            }
            // Right shift to check the next bit
            n = n >> 1;
        }
        
        return true;
    }
}