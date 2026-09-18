/* The Node structure is defined as
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Node prev = null;

    public int absDiff(Node root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inOrder(node.left);

        // Process current node
        if (prev != null) {
            minDiff = Math.min(minDiff, node.data - prev.data);
        }
        prev = node; // Update previous node

        // Traverse right subtree
        inOrder(node.right);
    }
}