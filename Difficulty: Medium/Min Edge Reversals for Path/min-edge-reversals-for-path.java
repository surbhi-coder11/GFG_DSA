import java.util.*;

class Solution {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // Build adjacency list (1-indexed nodes)
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Pair(v, 0)); // Original edge: weight 0
            adj.get(v).add(new Pair(u, 1)); // Reversed edge: weight 1
        }

        // Distance array initialized to infinity
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 0-1 BFS using Deque
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(src);

        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();

            if (curr == dst) {
                return dist[dst];
            }

            for (Pair neighbor : adj.get(curr)) {
                int nextNode = neighbor.node;
                int weight = neighbor.weight;

                if (dist[curr] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[curr] + weight;

                    if (weight == 0) {
                        deque.addFirst(nextNode); // 0-weight edges added to front
                    } else {
                        deque.addLast(nextNode);  // 1-weight edges added to back
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}