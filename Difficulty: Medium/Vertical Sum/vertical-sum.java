/* Structure of binary tree node 
class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // TreeMap to store sum corresponding to each horizontal distance (HD)
        // Sorted automatically by keys (from leftmost HD to rightmost HD)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Helper function to traverse the tree and calculate sums
        calculateVerticalSum(root, 0, map);
        
        // Extract the values from the sorted map into the result list
        for (int sum : map.values()) {
            result.add(sum);
        }
        
        return result;
    }
    
    private void calculateVerticalSum(Node node, int hd, TreeMap<Integer, Integer> map) {
        // Base case
        if (node == null) {
            return;
        }
        
        // Update the sum for the current horizontal distance
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        
        // Recur for left and right subtrees
        calculateVerticalSum(node.left, hd - 1, map);
        calculateVerticalSum(node.right, hd + 1, map);
    }
}