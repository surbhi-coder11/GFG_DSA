import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : arr) {
            // Check if num - 1 exists in our dynamic programming map
            int len = dp.getOrDefault(num - 1, 0) + 1;
            dp.put(num, len);
            maxLen = Math.max(maxLen, len);
        }

        return n - maxLen;
    }
}