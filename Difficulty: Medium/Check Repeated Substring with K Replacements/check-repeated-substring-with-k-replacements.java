import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();
        
        // If the string cannot be divided into blocks of size k
        if (n % k != 0) {
            return false;
        }
        
        // Map to store the frequency of each unique substring of length k
        Map<String, Integer> map = new HashMap<>();
        
        // Count frequencies of each block
        for (int i = 0; i < n; i += k) {
            String block = s.substring(i, i + k);
            map.put(block, map.getOrDefault(block, 0) + 1);
        }
        
        // Case 1: All blocks are already identical
        if (map.size() == 1) {
            return true;
        }
        
        // Case 2: There are exactly two different types of blocks
        if (map.size() == 2) {
            // Check if at least one of the blocks appears exactly once
            for (int count : map.values()) {
                if (count == 1) {
                    return true;
                }
            }
        }
        
        // Case 3: More than 2 unique blocks mean we need more than 1 replacement
        return false;
    }
}