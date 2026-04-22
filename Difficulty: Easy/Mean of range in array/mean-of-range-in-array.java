class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // 1. Create a Prefix Sum array
        // Using long to prevent overflow during sum accumulation
        long[] prefixSum = new long[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        
        // 2. Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            
            // Calculate sum in range [l, r]
            long rangeSum;
            if (l == 0) {
                rangeSum = prefixSum[r];
            } else {
                rangeSum = prefixSum[r] - prefixSum[l - 1];
            }
            
            // 3. Calculate the floor of the mean
            int numberOfElements = (r - l + 1);
            int mean = (int) (rangeSum / numberOfElements);
            
            result.add(mean);
        }
        
        return result;
    }
}