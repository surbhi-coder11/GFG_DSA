/* Definition for Node class
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution {
    public int getSize(Node root) {
        // Base Case: If the node is null, the size is 0
        if (root == null) {
            return 0;
        }

        // Recursive Step: 1 (current node) + size of left + size of right
        return 1 + getSize(root.left) + getSize(root.right);
    }
}