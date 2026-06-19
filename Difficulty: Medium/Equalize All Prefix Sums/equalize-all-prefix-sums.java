class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + arr[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = i / 2;
            long median = arr[m];

            long leftSum = pref[m + 1];
            long rightSum = pref[i + 1] - pref[m + 1];

            long leftCost = median * (m + 1L) - leftSum;
            long rightCost = rightSum - median * (i - m);

            ans.add((int)(leftCost + rightCost));
        }

        return ans;
    }
}