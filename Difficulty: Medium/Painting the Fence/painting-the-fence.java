class Solution {
    int countWays(int n, int k) {
        // code here.
        // Base Cases
        if (n == 0) return 0;
        if (n == 1) return k;
        
        // For n = 2
        // Same color: k ways (e.g., RR, BB)
        // Different color: k * (k - 1) ways (e.g., RB, BR)
        long same = k;
        long diff = (long) k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <= n; i++) {
            // The 'same' ways for post i is the 'diff' ways from post i-1
            same = diff;
            
            // The 'diff' ways for post i is (total ways of i-1) * (k-1)
            diff = (total * (k - 1));
            
            total = (same + diff);
        }

        return (int) total;
    }
}
