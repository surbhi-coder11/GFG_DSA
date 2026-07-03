import java.util.HashSet;

class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // dp1[i][j] stores the LCS of s1[0...i-1] and s2[0...j-1]
        int[][] dp1 = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp1[i][j] = dp1[i - 1][j - 1] + 1;
                } else {
                    dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i][j - 1]);
                }
            }
        }
        
        int originalLCS = dp1[n1][n2];
        
        // dp2[i][j] stores the LCS of s1[i...n1-1] and s2[j...n2-1]
        int[][] dp2 = new int[n1 + 1][n2 + 1];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp2[i][j] = dp2[i + 1][j + 1] + 1;
                } else {
                    dp2[i][j] = Math.max(dp2[i + 1][j], dp2[i][j + 1]);
                }
            }
        }
        
        int ans = 0;
        
        // Try inserting a character at every possible position 'i' in s1 (from 0 to n1)
        for (int i = 0; i <= n1; i++) {
            HashSet<Character> validChars = new HashSet<>();
            
            // Try matching with each character in s2
            for (int j = 0; j < n2; j++) {
                // If inserting s2.charAt(j) at position i forms an LCS of length originalLCS + 1
                if (dp1[i][j] + dp2[i][j + 1] == originalLCS) {
                    validChars.add(s2.charAt(j));
                }
            }
            
            ans += validChars.size();
        }
        
        return ans;
    }
}