class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int n = arr.length;
        int[] flip = new int[n];
        int cur = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) cur ^= flip[i - k];

            if ((arr[i] ^ cur) == 0) {
                if (i + k > n) return -1;
                ans++;
                cur ^= 1;
                flip[i] = 1;
            }
        }

        return ans;
    }
}
