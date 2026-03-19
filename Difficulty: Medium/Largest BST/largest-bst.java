class Solution {

    static class NodeValue {
        int min, max, size;

        NodeValue(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    static int maxSize = 0;

    static int largestBst(Node root) {
        maxSize = 0; // reset for each test case
        solve(root);
        return maxSize;
    }

    static NodeValue solve(Node root) {
        // Base case
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);

        // If valid BST
        if (left.max < root.data && root.data < right.min) {
            int size = left.size + right.size + 1;

            maxSize = Math.max(maxSize, size);

            return new NodeValue(
                Math.min(root.data, left.min),
                Math.max(root.data, right.max),
                size
            );
        }

        // If not BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
