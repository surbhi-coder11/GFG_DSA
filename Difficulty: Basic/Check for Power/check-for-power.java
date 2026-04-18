class Solution {
    public boolean isPower(int x, int y) {
        // Edge case: 1 raised to any power is always 1
        if (x == 1) {
            return y == 1;
        }

        // Initialize power with 1 (x^0)
        long pow = 1;
        
        // Multiply by x until we reach or exceed y
        while (pow < y) {
            pow = pow * x;
        }

        // If pow equals y, then y is a power of x
        return pow == y;
    }
}