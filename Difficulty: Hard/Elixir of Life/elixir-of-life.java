class Sol {
    int maxFrequency(String S) {
        int n = S.length();
        int[] Z = new int[n];
        
        // Construct the Z-array
        Z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                Z[i] = Math.min(r - i + 1, Z[i - l]);
            }
            while (i + Z[i] < n && S.charAt(Z[i]) == S.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > r) {
                l = i;
                r = i + Z[i] - 1;
            }
        }
        
        // count[v] will store the number of times value v appears in Z
        int[] count = new int[n + 2];
        for (int i = 0; i < n; i++) {
            count[Z[i]]++;
        }
        
        // Suffix sum: count[i] now becomes the number of prefixes of length >= i
        for (int i = n; i >= 1; i--) {
            count[i] += count[i + 1];
        }
        
        int maxFreq = 0;
        
        // Check all prefix lengths that are also valid suffixes
        for (int L = 1; L <= n; L++) {
            if (L == n || Z[n - L] == L) {
                maxFreq = Math.max(maxFreq, count[L]);
            }
        }
        
        return maxFreq;
    }
}