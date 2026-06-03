import java.util.*;

class Solution {
    public String findString(int n, int k) {
        // If n is 1, the sequence is simply all characters from 0 to k-1
        if (n == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(i);
            }
            return sb.toString();
        }

        // Set to store the visited combinations of length N
        Set<String> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();

        // Start with a prefix of (N-1) zeros
        StringBuilder startNode = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            startNode.append('0');
        }

        // Initialize the result with the starting node
        result.append(startNode);

        // Perform Hierholzer's-like DFS to find the Eulerian path
        dfs(startNode.toString(), k, visited, result);

        return result.toString();
    }

    private void dfs(String currNode, int k, Set<String> visited, StringBuilder result) {
        // Try all possible transitions from '0' to 'k-1'
        // Going backwards (k-1 down to 0) often helps optimal sequence generation in standard ordering
        for (int i = k - 1; i >= 0; i--) {
            String edge = currNode + i;
            
            if (!visited.contains(edge)) {
                visited.add(edge);
                
                // The next node drops the first character and appends the new one
                String nextNode = edge.substring(1);
                
                // Append the transition character to the final result string
                result.append(i);
                
                // Recursively move to the next state
                dfs(nextNode, k, visited, result);
            }
        }
    }
}