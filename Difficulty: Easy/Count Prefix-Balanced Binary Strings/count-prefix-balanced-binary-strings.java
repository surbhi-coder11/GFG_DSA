class Solution {
    public int prefixStrings(int n) {
        long MOD = 1000000007;

        // DP array to compute Catalan numbers up to n
        long[] catalan = new long[n + 1];

        // Base case: C(0) = 1, C(1) = 1
        catalan[0] = 1;
        if (n >= 1) {
            catalan[1] = 1;
        }

        // C(i) = sum(C(j) * C(i - 1 - j)) for j from 0 to i-1
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] = (catalan[i] + (catalan[j] * catalan[i - 1 - j]) % MOD) % MOD;
            }
        }

        return (int) catalan[n];
    }
}