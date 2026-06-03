class Solution {
    int maxSubstring(String s) {
        int maxFar = Integer.MIN_VALUE;
        int currMax = 0;
        boolean hasZero = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Transform: '0' becomes 1, '1' becomes -1
            int val = (ch == '0') ? 1 : -1;
            
            if (ch == '0') {
                hasZero = true;
            }

            currMax += val;

            if (currMax > maxFar) {
                maxFar = currMax;
            }

            // If current sum drops below 0, reset it to start a new subarray
            if (currMax < 0) {
                currMax = 0;
            }
        }

        // Edge case: If the string contains only 1s, return -1
        if (!hasZero) {
            return -1;
        }

        return maxFar;
    }
}