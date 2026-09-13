import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        // Step 1: Find the farthest node from node 1
        int[] result1 = bfs(1, adj, n);
        int nodeA = result1[0];

        // Step 2: Find the farthest node from nodeA to get the diameter
        int[] result2 = bfs(nodeA, adj, n);
        int diameter = result2[1];

        // The answer is the ceiling of (diameter / 2.0)
        return (diameter + 1) / 2;
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        queue.add(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentDist = dist[current];

            if (currentDist > maxDist) {
                maxDist = currentDist;
                farthestNode = current;
            }

            for (int neighbor : adj.get(current - 1)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = currentDist + 1;
                    queue.add(neighbor);
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }
}