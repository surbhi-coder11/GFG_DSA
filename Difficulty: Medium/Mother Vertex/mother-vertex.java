import java.util.*;

class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        // Step 1: Build the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        int lastFinishedVertex = 0;

        // Step 2: Find the candidate Mother Vertex
        // The last vertex to finish in a DFS traversal is the candidate
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                lastFinishedVertex = i;
            }
        }

        // Step 3: Verify the candidate
        // Reset visited array and check if all vertices are reachable from the candidate
        Arrays.fill(visited, false);
        dfs(lastFinishedVertex, adj, visited);

        for (boolean v : visited) {
            if (!v) return -1; // If any vertex is not reachable, no mother vertex exists
        }

        return lastFinishedVertex;
    }

    private void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}