class Solution {
    public int totalWays(int[] arr, int target) {
        // code here
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Constraints Check: 
        // 1. target cannot be greater than totalSum
        // 2. (totalSum + target) must be even and non-negative
        if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int s1 = (totalSum + target) / 2;
        return countSubsets(arr, s1);
    }

    private int countSubsets(int[] arr, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // Base case: one way to make sum 0 (empty subset)

        for (int num : arr) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[sum];
    }
}