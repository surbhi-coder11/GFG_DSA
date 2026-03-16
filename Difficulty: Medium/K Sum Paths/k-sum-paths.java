
// class Node {
//     int data;
//     Node left;
//     Node right;

//     Node(int data) {
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }


class Solution {
    public int countAllPaths(Node root, int k) {
        // code here
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // base case
        
        return dfs(root, 0, k, map);
        
    }
     private int dfs(Node node, long currSum, int k, Map<Long, Integer> map) {
        if(node == null) return 0;
        
        currSum += node.data;
        
        int count = 0;
        if(map.containsKey(currSum - k)) {
            count += map.get(currSum - k);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        count += dfs(node.left, currSum, k, map);
        count += dfs(node.right, currSum, k, map);
        
        map.put(currSum, map.get(currSum) - 1);
        
        return count;
     }
}