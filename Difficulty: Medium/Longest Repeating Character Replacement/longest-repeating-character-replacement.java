class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] count = new int[26]; // Frequency array for uppercase letters
        int maxFreq = 0; // Frequency of the most frequent character in the current window
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            // Add the current character to the window
            count[s.charAt(right) - 'A']++;
            
            // Update maxFreq to be the highest frequency of any single character in the current window
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // Window condition: (window size - maxFreq) > k
            // If we need to replace more than k characters, shrink the window from the left
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
                // Note: We don't strictly need to update maxFreq here because 
                // we are looking for a result larger than the current maxLength.
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}