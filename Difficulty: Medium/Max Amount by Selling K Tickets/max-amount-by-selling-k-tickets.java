class Solution {
    public int maxAmount(int[] arr, int k) {
        long mod = 1000000007;
        
        // Find the maximum number of tickets any seller has
        int maxTickets = 0;
        for (int num : arr) {
            if (num > maxTickets) {
                maxTickets = num;
            }
        }
        
        // Frequency array to store how many sellers have a specific number of tickets
        int[] freq = new int[maxTickets + 1];
        for (int num : arr) {
            freq[num]++;
        }
        
        long totalEarnings = 0;
        
        // Start selling from the highest ticket price down to 1
        for (int i = maxTickets; i > 0; i--) {
            if (freq[i] == 0) {
                continue;
            }
            
            // If the remaining k is less than the available tickets at this price level
            if (k <= freq[i]) {
                totalEarnings = (totalEarnings + (long) k * i) % mod;
                k = 0;
                break; // All k tickets are sold
            } else {
                // Sell all available tickets at this price level
                totalEarnings = (totalEarnings + (long) freq[i] * i) % mod;
                k -= freq[i];
                
                // These sellers now have (i - 1) tickets left
                freq[i - 1] += freq[i];
            }
        }
        
        return (int) totalEarnings;
    }
}