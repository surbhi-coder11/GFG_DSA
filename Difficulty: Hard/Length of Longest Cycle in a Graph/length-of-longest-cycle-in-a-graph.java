class Solution {
    public int longestCycle(int V, int[][] edges) {
        // code here
        int[] next = new int[V];
        Arrays.fill(next, -1);
        
        // Build graph (since each node has at most 1 outgoing)
        for (int[] e : edges) {
            next[e[0]] = e[1];
        }
        
        boolean[] visited = new boolean[V];
        int ans = -1;
        
        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;
            
            Map<Integer, Integer> map = new HashMap<>();
            int node = i;
            int step = 0;
            
            while (node != -1 && !visited[node]) {
                visited[node] = true;
                map.put(node, step++);
                
                node = next[node];
                
                if (node != -1 && map.containsKey(node)) {
                    // Cycle found
                    int cycleLen = step - map.get(node);
                    ans = Math.max(ans, cycleLen);
                    break;
                }
            }
        }
        
        return ans;
    }
}