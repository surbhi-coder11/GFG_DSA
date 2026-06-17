class Solution {
    public int maxProduct(int n) {
        // Base cases where a mandatory cut reduces the potential product
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int product = 1;
        
        // Keep cutting pieces of length 3 until n is 4 or less
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        
        // Multiply by the remaining piece (which will be 2, 3, or 4)
        product *= n;
        
        return product;
    }
}