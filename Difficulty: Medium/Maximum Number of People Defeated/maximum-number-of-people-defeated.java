class Solution {
    int maxPeopleDefeated(int p) {
        long low = 1;
        long high = p;
        long ans = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            // Formula to calculate sum of squares of first 'mid' natural numbers
            // Using BigInteger isn't strictly necessary if we cap high logically, 
            // but handling safely with long:
            long requiredStrength = (mid * (mid + 1) * (2 * mid + 1)) / 6;
            
            // If the required strength is within our limits and less than or equal to p
            if (requiredStrength >= 0 && requiredStrength <= p) {
                ans = mid;      // mid people can be defeated, try to find a larger number
                low = mid + 1;
            } else {
                high = mid - 1; // Needs too much strength, look for a smaller number
            }
        }
        
        return (int) ans;
    }
}