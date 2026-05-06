class Solution {
    int getLPSLength(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // lps[i] will store the length of the longest proper 
        // prefix which is also a suffix for the substring s[0...i]
        int[] lps = new int[n];
        
        // Length of the previous longest prefix suffix
        int len = 0;
        
        // lps[0] is always 0 because a proper prefix 
        // cannot be the whole string itself
        lps[0] = 0; 
        int i = 1;

        // Loop calculates lps[i] for i = 1 to n-1
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // If there is a mismatch
                if (len != 0) {
                    // Crucial step: try the previous longest prefix suffix
                    len = lps[len - 1];
                } else {
                    // No prefix matches, lps[i] is 0
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // The answer is the last value in the lps array
        return lps[n - 1];
    }
}