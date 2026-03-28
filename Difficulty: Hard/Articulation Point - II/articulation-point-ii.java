class Solution {
    
    static int timer;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V];

         timer = 0;

        // graph may be disconnected
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, tin, low, visited, isAP);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) res.add(i);
        }

        if (res.size() == 0) {
            res.add(-1);
        }

        return res;
    }
    private static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low, boolean[] visited, boolean[] isAP) {

        visited[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u, adj, tin, low, visited, isAP);

                low[u] = Math.min(low[u], low[v]);

                // articulation condition
                if (parent != -1 && low[v] >= tin[u]) {
                    isAP[u] = true;
                }

                children++;
            } else {
                // back edge
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        // root case
        if (parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }
}