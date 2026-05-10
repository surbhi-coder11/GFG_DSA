import java.util.*;

class Solution {
    public boolean palindromePair(String[] arr) {
        int n = arr.length;
        if (n < 2) return false;

        // Map to store string and its index for O(1) lookup
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            int len = s.length();

            // Divide the string into prefix and suffix at every possible position
            for (int j = 0; j <= len; j++) {
                String st1 = s.substring(0, j); // prefix
                String st2 = s.substring(j);    // suffix

                // Case 1: If prefix is a palindrome, look for reverse of suffix
                if (isPalindrome(st1)) {
                    String reversedSt2 = new StringBuilder(st2).reverse().toString();
                    if (map.containsKey(reversedSt2) && map.get(reversedSt2) != i) {
                        return true;
                    }
                }

                // Case 2: If suffix is a palindrome, look for reverse of prefix
                // j < len check prevents double counting empty suffixes/prefixes
                if (j < len && isPalindrome(st2)) {
                    String reversedSt1 = new StringBuilder(st1).reverse().toString();
                    if (map.containsKey(reversedSt1) && map.get(reversedSt1) != i) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Helper method to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}