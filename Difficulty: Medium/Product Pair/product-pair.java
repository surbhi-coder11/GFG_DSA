import java.util.HashSet;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        HashSet<Long> seen = new HashSet<>();
        
        for (int num : arr) {
            long x = (long) num;
            
            // Avoid division by zero
            if (x == 0) {
                // If target is 0 and we have already seen a 0 or any other number, 
                // x * complement = 0, so a pair is found.
                if (target == 0 && !seen.isEmpty()) {
                    return true;
                }
            } else {
                // Check if target is perfectly divisible by the current element
                if (target % x == 0) {
                    long required = target / x;
                    if (seen.contains(required)) {
                        return true;
                    }
                }
            }
            
            // Add the current number to the set for future complement checks
            seen.add(x);
        }
        
        // If target is 0, we need to handle the case where 0 comes first 
        // and a non-zero element comes later.
        if (target == 0 && seen.contains(0L) && seen.size() > 1) {
            return true;
        }
        
        return false;
    }
}