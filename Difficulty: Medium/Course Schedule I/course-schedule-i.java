class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
           List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        
        // Build graph
        for (int[] p : prerequisites) {
            int x = p[0], y = p[1];
            adj.get(y).add(x);   // y → x
            indegree[x]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // Add nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        return count == n;
    }
}