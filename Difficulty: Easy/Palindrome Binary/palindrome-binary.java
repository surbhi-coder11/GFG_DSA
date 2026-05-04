class Solution {
    public boolean isBinaryPalindrome(int n) {
        // Step 1: Convert the integer n to its binary string representation
        String binary = Integer.toBinaryString(n);
        
        // Step 2: Initialize two pointers
        int left = 0;
        int right = binary.length() - 1;
        
        // Step 3: Check for palindrome property
        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        
        return true; // Is a palindrome
    }
}