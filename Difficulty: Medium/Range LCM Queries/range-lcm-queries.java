import java.util.*;

class Solution {
    long[] tree;
    int n;

    // Helper function to calculate GCD
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper function to calculate LCM
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        long commonDivisor = gcd(a, b);
        return (a * b) / commonDivisor;
    }

    // Build the Segment Tree
    private void build(int node, int start, int end, int[] arr) {
        if (start == end) {
            tree[node] = (long) arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid, arr);
        build(2 * node + 1, mid + 1, end, arr);
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    // Update the value at a specific index
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = (long) val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid)
            update(2 * node, start, mid, idx, val);
        else
            update(2 * node + 1, mid + 1, end, idx, val);
        
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    // Query the LCM in range [L, R]
    private long query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) return 1; // Neutral element for LCM
        if (L <= start && end <= R) return tree[node];
        
        int mid = (start + end) / 2;
        long leftLcm = query(2 * node, start, mid, L, R);
        long rightLcm = query(2 * node + 1, mid + 1, end, L, R);
        return lcm(leftLcm, rightLcm);
    }

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        n = arr.length;
        tree = new long[4 * n];
        build(1, 0, n - 1, arr);

        ArrayList<Long> results = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            if (type == 1) {
                // Update Query: [1, index, value]
                update(1, 0, n - 1, q[1], q[2]);
            } else {
                // Range Query: [2, L, R]
                results.add(query(1, 0, n - 1, q[1], q[2]));
            }
        }
        return results;
    }
}