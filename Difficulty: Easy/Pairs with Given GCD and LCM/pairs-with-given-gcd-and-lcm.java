class Solution {
    public int pairCount(int x, int y) {
        // LCM must be divisible by GCD
        if (y % x != 0) {
            return 0;
        }

        int k = y / x;
        int count = 0;

        // Find pairs (p, q) such that p * q = k and gcd(p, q) == 1
        for (int p = 1; p * p <= k; p++) {
            if (k % p == 0) {
                int q = k / p;
                if (gcd(p, q) == 1) {
                    // If p != q, both (p, q) and (q, p) are valid distinct pairs
                    // If p == q, it's counted only once
                    count += (p == q) ? 1 : 2;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}