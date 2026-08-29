class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1000000007;
        int len = s.length();

        // dp[r] stores the number of subsequences with remainder r modulo n
        long[] dp = new long[n];

        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            long[] nextDp = new long[n];

            // 1. Keep all existing subsequences (exclude s[i])
            for (int r = 0; r < n; r++) {
                nextDp[r] = dp[r];
            }

            // 2. Form new subsequences by extending existing ones with s[i]
            for (int r = 0; r < n; r++) {
                if (dp[r] > 0) {
                    int newRem = (r * 10 + digit) % n;
                    nextDp[newRem] = (nextDp[newRem] + dp[r]) % MOD;
                }
            }

            // 3. Start a new single-digit subsequence with s[i]
            int singleRem = digit % n;
            nextDp[singleRem] = (nextDp[singleRem] + 1) % MOD;

            dp = nextDp;
        }

        // Remainder 0 represents subsequences divisible by n
        return (int) dp[0];
    }
}