import java.util.*;

class Solution {
    // Binary Indexed Tree (Fenwick Tree) to store max height for height values up to 1000
    private static class FenwickTree {
        int[] tree;
        int size;

        public FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        public void update(int idx, int val) {
            for (; idx <= size; idx += idx & -idx) {
                tree[idx] = Math.max(tree[idx], val);
            }
        }

        public int query(int idx) {
            int maxVal = 0;
            for (; idx > 0; idx -= idx & -idx) {
                maxVal = Math.max(maxVal, tree[idx]);
            }
            return maxVal;
        }
    }

    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        int[][] discs = new int[n][2];
        int maxH = 0;

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
            maxH = Math.max(maxH, h[i]);
        }

        // Sort by radius ascending. 
        // If radius is the same, sort by height descending to avoid using a disc with the same radius.
        Arrays.sort(discs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        FenwickTree bit = new FenwickTree(maxH);
        int totalMaxHeight = 0;

        for (int i = 0; i < n; i++) {
            int currentR = discs[i][0];
            int currentH = discs[i][1];

            // Query max height formed by discs with strictly smaller height
            int bestPrevious = bit.query(currentH - 1);
            int currentDP = bestPrevious + currentH;

            // Update global maximum
            totalMaxHeight = Math.max(totalMaxHeight, currentDP);

            // Update Fenwick Tree at position currentH with currentDP
            bit.update(currentH, currentDP);
        }

        return totalMaxHeight;
    }
}