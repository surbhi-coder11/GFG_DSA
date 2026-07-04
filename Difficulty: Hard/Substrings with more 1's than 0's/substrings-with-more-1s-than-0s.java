class Solution {

    void update(int[] bit, int idx, int val) {
        while (idx < bit.length) {
            bit[idx] += val;
            idx += idx & -idx;
        }
    }

    int query(int[] bit, int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    public int countSubstring(String s) {
        int n = s.length();

        int offset = n + 2;
        int[] bit = new int[2 * n + 5];

        int prefix = 0;
        long ans = 0;

        update(bit, offset, 1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                prefix++;
            else
                prefix--;

            ans += query(bit, prefix + offset - 1);
            update(bit, prefix + offset, 1);
        }

        return (int) ans;
    }
}