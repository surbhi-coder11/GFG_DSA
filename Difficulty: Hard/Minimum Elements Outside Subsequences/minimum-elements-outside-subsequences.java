import java.util.Arrays;

class Solution {
    private int[][][] dp;

    public int minCount(int[] arr) {
        int n = arr.length;
        // lastInc and lastDec values range from 0 to 101
        // 0 represents 'no element selected yet'
        dp = new int[n][102][102];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 101; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 101, arr);
    }

    private int solve(int idx, int lastInc, int lastDec, int[] arr) {
        if (idx == arr.length) {
            return 0;
        }

        if (dp[idx][lastInc][lastDec] != -1) {
            return dp[idx][lastInc][lastDec];
        }

        // Option 1: Skip the current element (it stays unselected)
        int ans = 1 + solve(idx + 1, lastInc, lastDec, arr);

        // Option 2: Add to strictly increasing subsequence
        if (arr[idx] > lastInc) {
            ans = Math.min(ans, solve(idx + 1, arr[idx], lastDec, arr));
        }

        // Option 3: Add to strictly decreasing subsequence
        if (arr[idx] < lastDec) {
            ans = Math.min(ans, solve(idx + 1, lastInc, arr[idx], arr));
        }

        return dp[idx][lastInc][lastDec] = ans;
    }
}