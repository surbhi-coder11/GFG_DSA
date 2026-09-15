class Solution {
    static void linkDelete(Node head, int n, int m) {
        Node curr = head;

        while (curr != null) {
            // 1. Skip m - 1 nodes to land on the m-th node
            for (int count = 1; count < m && curr != null; count++) {
                curr = curr.next;
            }

            // If we reached the end while skipping, stop
            if (curr == null) {
                return;
            }

            // 2. Start from the node after the m-th node and skip n nodes
            Node temp = curr.next;
            for (int count = 1; count <= n && temp != null; count++) {
                temp = temp.next;
            }

            // 3. Link the m-th node to the node after the n deleted nodes
            curr.next = temp;

            // 4. Move curr to resume the process
            curr = temp;
        }
    }
}