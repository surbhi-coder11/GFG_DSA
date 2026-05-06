/* class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
} */

class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        // 1. Reverse the first k nodes of the linked list
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // 2. 'next' is now a pointer to the (k+1)th node. 
        // Recursively call for the list starting from 'next' 
        // and make the rest of the list as next of the current head.
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // 3. 'prev' is now the new head of the reversed group
        return prev;
    }
}