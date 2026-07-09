class Solution {
    public int countKdivPairs(int[] arr, int k) {
        // Frequency array to store the count of remainders
        long[] remCount = new long[k];
        int pairCount = 0;
        
        for (int num : arr) {
            // Find the remainder of the current element
            int rem = num % k;
            
            // To handle potential negative numbers safely (though constraints say arr[i] >= 1)
            if (rem < 0) {
                rem += k;
            }
            
            // Calculate the required complement remainder
            int complement = (k - rem) % k;
            
            // If the complement remainder exists in our frequency array, 
            // it means those elements can form a valid pair with the current element
            pairCount += remCount[complement];
            
            // Increment the frequency of the current remainder
            remCount[rem]++;
        }
        
        return pairCount;
    }
}