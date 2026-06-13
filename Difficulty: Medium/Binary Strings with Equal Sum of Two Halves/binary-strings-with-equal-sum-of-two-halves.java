class Solution {
    public int computeValue(int n) {
        long mod = 1000000007;
        
        // We need to compute (2n)! / (n! * n!) % mod
        long numerator = 1;
        long denominator = 1;
        
        // Calculate (2n)! and n! in a single loop to optimize
        for (int i = 1; i <= n; i++) {
            numerator = (numerator * (n + i)) % mod; // Multiplies (n+1) * (n+2) * ... * 2n
            denominator = (denominator * i) % mod;   // Multiplies 1 * 2 * ... * n
        }
        
        // Result = (numerator * ModularInverse(denominator)) % mod
        long ans = (numerator * power(denominator, mod - 2, mod)) % mod;
        
        return (int) ans;
    }
    
    // Fast exponentiation helper function to compute (base^exp) % mod
    private long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}