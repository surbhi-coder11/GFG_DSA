class Solution {
    public int getCount(Node node, int k) {
        if (node == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        queue.add(node);
        levelQueue.add(1);

        int count = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int level = levelQueue.poll();

            // Check if current node is a leaf
            if (curr.left == null && curr.right == null) {
                if (k >= level) {
                    k -= level;
                    count++;
                } else {
                    break; // Cannot afford any more leaves
                }
            }

            if (curr.left != null) {
                queue.add(curr.left);
                levelQueue.add(level + 1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                levelQueue.add(level + 1);
            }
        }

        return count;
    }
}