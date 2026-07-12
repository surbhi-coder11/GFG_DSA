class Solution {
    long luckyPermutations(int N, int M, int arr[], int [][] graph) {
        // Build adjacency matrix (nodes are 1-indexed as per constraints)
        boolean[][] adj = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            adj[u][v] = true;
            adj[v][u] = true;
        }

        int numStates = 1 << N;
        long[][] dp = new long[numStates][N];

        // Base case: every single element is a valid path of length 1
        for (int i = 0; i < N; i++) {
            dp[1 << i][i] = 1;
        }

        // Iterate through all masks
        for (int mask = 1; mask < numStates; mask++) {
            for (int i = 0; i < N; i++) {
                // If the i-th element is not in the current mask, skip
                if ((mask & (1 << i)) == 0) continue;
                
                // If no paths reach this state, skip
                if (dp[mask][i] == 0) continue;

                // Try to transition to the next element j
                for (int j = 0; j < N; j++) {
                    // j must not be visited yet
                    if ((mask & (1 << j)) == 0) {
                        // There must be an edge between arr[i] and arr[j]
                        if (adj[arr[i]][arr[j]]) {
                            dp[mask | (1 << j)][j] += dp[mask][i];
                        }
                    }
                }
            }
        }

        // Sum up all permutations that visit all N elements
        long totalLuckyPermutations = 0;
        int fullMask = numStates - 1;
        for (int i = 0; i < N; i++) {
            totalLuckyPermutations += dp[fullMask][i];
        }

        return totalLuckyPermutations;
    }
}