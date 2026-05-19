import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // If start and end are already the same, 0 steps are needed
        if (start == end) {
            return 0;
        }

        int MOD = 1000;
        
        // dist array tracks the minimum operations to reach a number
        int[] dist = new int[MOD];
        Arrays.fill(dist, -1); 
        
        Queue<Integer> q = new LinkedList<>();
        
        // Initialize the starting conditions
        q.add(start);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            int steps = dist[curr];
            
            for (int factor : arr) {
                int next = (curr * factor) % MOD;
                
                // If this remainder/number hasn't been visited yet
                if (dist[next] == -1) {
                    dist[next] = steps + 1;
                    
                    // Optimization: Immediate termination check
                    if (next == end) {
                        return dist[next];
                    }
                    
                    q.add(next);
                }
            }
        }
        
        // If the queue becomes empty and end wasn't reached
        return -1;
    }
}