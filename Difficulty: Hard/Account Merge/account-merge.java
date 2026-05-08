import java.util.*;

class Solution {
    // Standard DSU class with Path Compression and Union by Rank
    class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]); // Path compression
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootI] = rootJ;
                    rank[rootJ]++;
                }
            }
        }
    }

    public ArrayList<ArrayList<String>> accMerge(String[][] arr) {
        int n = arr.length;
        DisjointSet ds = new DisjointSet(n);
        
        // Map: Email -> Account Index
        Map<String, Integer> emailToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                String email = arr[i][j];
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    // If email seen before, union current account with existing one
                    ds.union(i, emailToIndex.get(email));
                }
            }
        }

        // Group emails by their root representative
        Map<Integer, List<String>> mergedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int root = ds.find(entry.getValue());
            mergedMap.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Prepare final result
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : mergedMap.entrySet()) {
            int index = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails); // Required: Lexicographically sorted
            
            ArrayList<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(arr[index][0]); // Add Name
            mergedAccount.addAll(emails);    // Add Sorted Emails
            result.add(mergedAccount);
        }

        return result;
    }
}