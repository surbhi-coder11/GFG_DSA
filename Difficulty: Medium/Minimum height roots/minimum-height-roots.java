class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new HashSet<>());
        }
        
        // Build graph
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        // Find initial leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        int remainingNodes = V;
        
        // Trim leaves
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            
            for (int leaf : leaves) {
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            
            leaves = newLeaves;
        }
        
        // Convert List → ArrayList (FIX)
        return new ArrayList<>(leaves);
    }
}