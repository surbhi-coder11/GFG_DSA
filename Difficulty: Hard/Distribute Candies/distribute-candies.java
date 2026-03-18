/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int moves =0;
    public int distCandy(Node root) {
        // code here
        dfs(root);
        return moves;
        
    }
    private int dfs(Node root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        // count moves from children to current node
        moves += Math.abs(left) + Math.abs(right);

        // return excess candies to parent
        return root.data + left + right - 1;
    }
}