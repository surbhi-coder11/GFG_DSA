/* Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // If the subtree is null, it's technically a subtree of any tree
        if (root2 == null) return true;
        
        // If the main tree is null but subtree isn't, it can't be a match
        if (root1 == null) return false;

        // 1. Check if trees are identical starting from the current root
        if (isIdentical(root1, root2)) {
            return true;
        }

        // 2. If not identical at current root, search in left and right children
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    // Helper function to check if two trees are exactly the same
    private boolean isIdentical(Node n1, Node n2) {
        // Both null means they are identical
        if (n1 == null && n2 == null) return true;
        
        // One is null or values don't match
        if (n1 == null || n2 == null || n1.data != n2.data) return false;

        // Recursively check left and right subtrees
        return isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
    }
}