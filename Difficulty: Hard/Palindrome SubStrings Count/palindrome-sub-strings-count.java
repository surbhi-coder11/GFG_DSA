class Solution {
    public int countPS(String s) {
        int n = s.length();
        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            // 1. Odd length palindromes (centered at index i)
            totalCount += expandAroundCenter(s, i, i);

            // 2. Even length palindromes (centered between index i and i+1)
            totalCount += expandAroundCenter(s, i, i + 1);
        }

        return totalCount;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;

        // Expand outwards as long as characters match and indices are within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // The problem statement requires the palindrome length to be >= 2
            if (right - left + 1 >= 2) {
                count++;
            }
            left--;
            right++;
        }

        return count;
    }
}