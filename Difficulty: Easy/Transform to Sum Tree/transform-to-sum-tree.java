/* Structure for Tree Node 
class Node {
    int data;
    Node left, right;
    
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}; */

class Solution {
    public void toSumTree(Node root) {
        // Call the helper function to perform the transformation
        transform(root);
    }
    
    // Helper function that updates the tree and returns the sum of the old subtree
    private int transform(Node root) {
        // Base case: if the node is null, its contribution to the sum is 0
        if (root == null) {
            return 0;
        }
        
        // Store the original value of the current node
        int oldVal = root.data;
        
        // Recursively compute the sum of left and right subtrees
        int leftSum = transform(root.left);
        int rightSum = transform(root.right);
        
        // Update the current node's data to be the sum of its subtrees
        root.data = leftSum + rightSum;
        
        // Return the total sum of the subtree rooted at this node in the original tree
        return oldVal + root.data;
    }
}