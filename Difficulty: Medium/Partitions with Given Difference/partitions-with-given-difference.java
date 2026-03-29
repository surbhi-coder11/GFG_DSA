class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int n = arr.length;

        int total = 0;
        for (int num : arr) total += num;

        // invalid cases
        if ((total + diff) % 2 != 0 || total < diff) return 0;

        int target = (total + diff) / 2;

        // dp[i] = number of ways to get sum i
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}
