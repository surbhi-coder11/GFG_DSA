import java.util.Arrays;

class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        int[] dist = new int[V];
        // Initialize distances to 0 to cover disconnected components
        Arrays.fill(dist, 0);

        // Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Perform V-th relaxation step to check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (dist[u] + weight < dist[v]) {
                return true; // Negative weight cycle detected
            }
        }

        return false;
    }
}