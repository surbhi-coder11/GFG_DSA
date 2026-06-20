import java.util.TreeSet;

class Solution {
    public String chooseSwap(String s) {
        // Step 1: Store all unique characters in a sorted set
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        // Step 2: Iterate through the string to find the first eligible swap
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Remove the current character from the set since we are passing it
            set.remove(ch);

            // If the set is empty, no smaller character can exist ahead
            if (set.isEmpty()) {
                break;
            }

            // Get the smallest available character remaining
            char smallestAhead = set.first();

            // If it is smaller than the current character, we swap them
            if (smallestAhead < ch) {
                return performSwap(s, ch, smallestAhead);
            }
        }

        // If no swap can make the string lexicographically smaller, return original
        return s;
    }

    // Helper method to swap all occurrences of two characters
    private String performSwap(String s, char oldChar, char newChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == oldChar) {
                sb.append(newChar);
            } else if (current == newChar) {
                sb.append(oldChar);
            } else {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}