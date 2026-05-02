class Solution {
    public int findPosition(int n) {
        // Step 1: Check if n is 0 or has more than one set bit
        // A power of 2 in binary looks like 100...0
        // (n & (n - 1)) == 0 is a classic trick to check for a single set bit
        if (n <= 0 || (n & (n - 1)) != 0) {
            return -1;
        }

        int position = 0;
        
        // Step 2: Find the position by shifting right until n becomes 0
        while (n > 0) {
            n = n >> 1;
            position++;
        }

        return position;
    }
}