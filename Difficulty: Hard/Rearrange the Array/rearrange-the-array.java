import java.util.*;

class Solution {
    int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n];
        
        // Map to store the maximum power of each prime factor needed for LCM
        Map<Integer, Integer> maxPrimePowers = new HashMap<>();
        
        // Step 1: Find all cycle lengths and break them into prime factors
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleLength = 0;
                int curr = i;
                
                // Traverse the cycle
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr] - 1; // Convert 1-based to 0-based indexing
                    cycleLength++;
                }
                
                // Get prime factorization of the current cycle length
                Map<Integer, Integer> localFactors = getPrimeFactors(cycleLength);
                for (Map.Entry<Integer, Integer> entry : localFactors.entrySet()) {
                    int prime = entry.getKey();
                    int power = entry.getValue();
                    maxPrimePowers.put(prime, Math.max(maxPrimePowers.getOrDefault(prime, 0), power));
                }
            }
        }
        
        // Step 2: Compute the LCM safely using modulo 10^9 + 7
        long ans = 1;
        long MOD = 1000000007;
        
        for (Map.Entry<Integer, Integer> entry : maxPrimePowers.entrySet()) {
            int prime = entry.getKey();
            int power = entry.getValue();
            
            long primePowerValue = 1;
            for (int i = 0; i < power; i++) {
                primePowerValue = (primePowerValue * prime) % MOD;
            }
            
            ans = (ans * primePowerValue) % MOD;
        }
        
        return (int) ans;
    }
    
    // Helper method to find prime factors of a number
    private Map<Integer, Integer> getPrimeFactors(int num) {
        Map<Integer, Integer> factors = new HashMap<>();
        int d = 2;
        while (d * d <= num) {
            if (num % d == 0) {
                int count = 0;
                while (num % d == 0) {
                    count++;
                    num /= d;
                }
                factors.put(d, count);
            }
            d++;
        }
        if (num > 1) {
            factors.put(num, 1);
        }
        return factors;
    }
}