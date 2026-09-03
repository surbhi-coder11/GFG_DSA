class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // dp0 stores max sum ending at previous index if replaced with 1
        // dp1 stores max sum ending at previous index if kept original
        int dp0 = 0;
        int dp1 = 0;

        for (int i = 1; i < n; i++) {
            // New dp values for current index i
            int nextDp0 = Math.max(
                dp0 + Math.abs(1 - 1),                   // Previous was 1, Current is 1
                dp1 + Math.abs(1 - arr[i - 1])           // Previous was original, Current is 1
            );

            int nextDp1 = Math.max(
                dp0 + Math.abs(arr[i] - 1),               // Previous was 1, Current is original
                dp1 + Math.abs(arr[i] - arr[i - 1])       // Previous was original, Current is original
            );

            dp0 = nextDp0;
            dp1 = nextDp1;
        }

        return Math.max(dp0, dp1);
    }
}