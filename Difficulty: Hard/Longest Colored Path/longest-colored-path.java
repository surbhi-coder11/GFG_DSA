import java.util.*;

class Solution {

    public int longestPath(String s, int[][] edges) {
        int n = s.length();

        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            g[u].add(v);
            g[v].add(u);
        }

        // Build parent array and traversal order
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int[] order = new int[n];
        int cnt = 0;

        order[cnt++] = 0;

        for (int i = 0; i < n; i++) {
            int u = order[i];

            for (int v : g[u]) {
                if (v == parent[u])
                    continue;

                parent[v] = u;
                order[cnt++] = v;
            }
        }

        // down[u] = longest same-color path starting from u
        // going down into its subtree
        int[] down = new int[n];
        Arrays.fill(down, 1);

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            for (int v : g[u]) {
                if (parent[v] == u &&
                    s.charAt(v) == s.charAt(u)) {

                    down[u] = Math.max(down[u], 1 + down[v]);
                }
            }
        }

        // up[u] = longest same-color path from u
        // going through its parent side
        int[] up = new int[n];
        Arrays.fill(up, 1);

        // arm[u] = longest same-color path starting at u
        // in any direction
        int[] arm = new int[n];

        for (int u : order) {

            int best1 = 0;
            int best2 = 0;
            int bestChild = -1;

            for (int v : g[u]) {

                if (s.charAt(v) != s.charAt(u))
                    continue;

                int value;

                if (parent[v] == u) {
                    value = down[v];
                } else {
                    value = up[u];
                }

                if (value > best1) {
                    best2 = best1;
                    best1 = value;
                    bestChild = v;
                } else if (value > best2) {
                    best2 = value;
                }
            }

            arm[u] = 1 + best1;

            // Calculate up[] for children
            for (int v : g[u]) {

                if (parent[v] != u)
                    continue;

                if (s.charAt(v) != s.charAt(u))
                    continue;

                if (v == bestChild) {
                    up[v] = 1 + best2;
                } else {
                    up[v] = 1 + best1;
                }
            }
        }

        int ans = 1;

        // Case 1: Entire path has the same color
        for (int u = 0; u < n; u++) {

            int best1 = 0;
            int best2 = 0;

            for (int v : g[u]) {

                if (s.charAt(v) != s.charAt(u))
                    continue;

                int value;

                if (parent[v] == u) {
                    value = down[v];
                } else {
                    value = up[u];
                }

                if (value > best1) {
                    best2 = best1;
                    best1 = value;
                } else if (value > best2) {
                    best2 = value;
                }
            }

            ans = Math.max(ans, 1 + best1 + best2);
        }

        // Case 2: Path contains R -> B transition
        for (int[] e : edges) {

            int u = e[0] - 1;
            int v = e[1] - 1;

            if (s.charAt(u) == s.charAt(v))
                continue;

            ans = Math.max(ans, arm[u] + arm[v]);
        }

        return ans;
    }
}