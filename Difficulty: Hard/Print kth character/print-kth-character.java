import java.util.Arrays;
import java.util.Comparator;

class Solution {
    char PrintKthCharacter(String S, int K) {
        int n = S.length();
        
        // Step 1: Create an array of suffix starting indices
        Integer[] suffixes = new Integer[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = i;
        }
        
        // Step 2: Sort the suffix indices lexicographically based on the substring they represent
        Arrays.sort(suffixes, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return S.substring(i1).compareTo(S.substring(i2));
            }
        });
        
        // Step 3: Process substrings ordered lexicographically using LCP (Longest Common Prefix)
        for (int i = 0; i < n; i++) {
            int start = suffixes[i];
            
            // Calculate how many characters this suffix shares with the previous sorted suffix
            int lcp = 0;
            if (i > 0) {
                int prevStart = suffixes[i - 1];
                while (start + lcp < n && prevStart + lcp < n && S.charAt(start + lcp) == S.charAt(prevStart + lcp)) {
                    lcp++;
                }
            }
            
            // The unique substrings contributed by this suffix start from length (lcp + 1) up to its maximum remaining length
            int totalAvailableUniqueLen = n - start;
            
            // Iterate through the valid lengths of unique substrings from this suffix
            for (int len = lcp + 1; len <= totalAvailableUniqueLen; len++) {
                if (K <= len) {
                    // Found the substring containing our K-th character!
                    return S.charAt(start + K - 1);
                }
                // Subtract the length of the current unique substring from K
                K -= len;
            }
        }
        
        return ' ';
    }
}