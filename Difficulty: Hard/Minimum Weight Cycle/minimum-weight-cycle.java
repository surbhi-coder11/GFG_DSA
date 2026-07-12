import java.util.*;

public class Solution {
    static class Node implements Comparable<Node> {
        int v, weight;
        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public int findMinCycle(int V, int[][] edges) {
        // Build the adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Node(v, w));
            adj.get(v).add(new Node(u, w));
        }

        int minCycleWeight = Integer.MAX_VALUE;

        // Iterate through each edge to find the shortest alternate path
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            // Find shortest path between u and v without using the direct edge (u, v)
            int shortestPath = dijkstra(V, adj, u, v, w);

            if (shortestPath != Integer.MAX_VALUE) {
                minCycleWeight = Math.min(minCycleWeight, shortestPath + w);
            }
        }

        return minCycleWeight == Integer.MAX_VALUE ? -1 : minCycleWeight;
    }

    private int dijkstra(int V, List<List<Node>> adj, int src, int dest, int edgeWeightToIgnore) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.v;
            int d = curr.weight;

            if (d > dist[u]) continue;
            if (u == dest) return dist[dest];

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.v;
                int w = neighbor.weight;

                // Ignore the direct edge between src and dest we are testing
                if ((u == src && v == dest && w == edgeWeightToIgnore) || 
                    (u == dest && v == src && w == edgeWeightToIgnore)) {
                    continue;
                }

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        
        return dist[dest];
    }
}