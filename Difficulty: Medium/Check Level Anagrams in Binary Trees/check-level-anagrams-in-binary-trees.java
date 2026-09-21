import java.util.*;

/* 
Structure of binary tree Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} 
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        // Base edge cases
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int n1 = q1.size();
            int n2 = q2.size();

            // If a level has a different number of nodes, they cannot be anagrams
            if (n1 != n2) return false;

            // Collect values at current level for both trees
            List<Integer> level1 = new ArrayList<>();
            List<Integer> level2 = new ArrayList<>();

            for (int i = 0; i < n1; i++) {
                Node curr1 = q1.poll();
                Node curr2 = q2.poll();

                level1.add(curr1.data);
                level2.add(curr2.data);

                if (curr1.left != null) q1.add(curr1.left);
                if (curr1.right != null) q1.add(curr1.right);

                if (curr2.left != null) q2.add(curr2.left);
                if (curr2.right != null) q2.add(curr2.right);
            }

            // Check if current level values are anagrams
            Collections.sort(level1);
            Collections.sort(level2);

            if (!level1.equals(level2)) {
                return false;
            }
        }

        // Both queues should be empty if all levels matched completely
        return q1.isEmpty() && q2.isEmpty();
    }
}