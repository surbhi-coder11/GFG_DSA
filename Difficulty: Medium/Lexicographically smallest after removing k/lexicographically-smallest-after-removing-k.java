class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        
        // Step 1: Check if n is a power of 2
        boolean isPowerOfTwo = (n > 0) && ((n & (n - 1)) == 0);
        
        // Step 2: Correct the value of k
        if (isPowerOfTwo) {
            k = k / 2;
        } else {
            k = k * 2;
        }
        
        // Step 3: Handle edge cases
        if (k >= n) {
            return "-1";
        }
        if (k == 0) {
            return s;
        }
        
        // Step 4: Greedy removal using a stack (StringBuilder used as stack for efficiency)
        StringBuilder stack = new StringBuilder();
        int remainingRemovals = k;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // While stack is not empty, current char is smaller than top, and we still need to remove characters
            while (stack.length() > 0 && stack.charAt(stack.length() - 1) > ch && remainingRemovals > 0) {
                stack.deleteCharAt(stack.length() - 1); // pop
                remainingRemovals--;
            }
            stack.append(ch); // push
        }
        
        // If we still need to remove characters, remove them from the end
        while (remainingRemovals > 0) {
            stack.deleteCharAt(stack.length() - 1);
            remainingRemovals--;
        }
        
        return stack.toString();
    }
}