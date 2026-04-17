class Solution {
    boolean canFormPalindrome(String s) {
        // Since the string consists of lowercase English letters, 
        // we can use an array of size 26 to store frequencies.
        int[] charCounts = new int[26];
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        
        int oddCount = 0;
        
        // Count how many characters have an odd frequency
        for (int count : charCounts) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // If more than 1 character has an odd frequency, 
        // it's impossible to form a palindrome.
        return oddCount <= 1;
    }
}