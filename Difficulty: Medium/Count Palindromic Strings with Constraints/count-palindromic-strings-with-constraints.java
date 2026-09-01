class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1_000_000_007L;
        long totalCount = 0;

        // perm keeps track of P(k, m) = number of ways to pick m distinct characters
        long perm = 1;

        for (int L = 1; L <= n; L++) {
            int m = L / 2; // number of pairs

            if (L % 2 == 0) {
                // Update P(k, m) for the current pair
                perm = (perm * (k - m + 1)) % MOD;
                totalCount = (totalCount + perm) % MOD;
            } else {
                // Middle character can only be chosen from remaining (k - m) unused characters
                long oddWays = (perm * (k - m)) % MOD;
                totalCount = (totalCount + oddWays) % MOD;
            }
        }

        return (int) totalCount;
    }
}