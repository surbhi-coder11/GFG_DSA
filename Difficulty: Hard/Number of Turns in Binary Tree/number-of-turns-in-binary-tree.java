class Solution {
    static int count = 0;

    // Helper to find Lowest Common Ancestor (LCA)
    private Node findLCA(Node root, int p, int q) {
        if (root == null) return null;
        if (root.data == p || root.data == q) return root;

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // Traverses towards target node and counts turns
    private boolean countTurns(Node node, int target, boolean turnLeft) {
        if (node == null) return false;
        if (node.data == target) return true;

        if (turnLeft) {
            // Path went left
            if (countTurns(node.left, target, true)) return true;
            if (countTurns(node.right, target, false)) {
                count++; // Direction changed from left to right
                return true;
            }
        } else {
            // Path went right
            if (countTurns(node.right, target, false)) return true;
            if (countTurns(node.left, target, true)) {
                count++; // Direction changed from right to left
                return true;
            }
        }
        return false;
    }

    public int numberOfTurns(Node root, int p, int q) {
        count = 0;
        Node lca = findLCA(root, p, q);

        if (lca == null) return -1;

        // If LCA is one of the nodes, search from LCA towards the other node
        if (lca.data == p) {
            countTurns(lca.left, q, true);
            countTurns(lca.right, q, false);
        } else if (lca.data == q) {
            countTurns(lca.left, p, true);
            countTurns(lca.right, p, false);
        } else {
            // LCA is in between p and q
            countTurns(lca.left, p, true);
            countTurns(lca.right, p, false);

            countTurns(lca.left, q, true);
            countTurns(lca.right, q, false);

            // Path from LCA to p and LCA to q form a turn at LCA itself
            count++;
        }

        return count == 0 ? -1 : count;
    }
}