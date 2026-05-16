/* Following is the Linked list node structure
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    void reorderlist(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' is now at the middle. Split the list into two halves.
        Node head2 = slow.next;
        slow.next = null; // Disconnect the first half from the second half

        // Step 2: Reverse the second half of the linked list
        Node prev = null;
        Node curr = head2;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev; // 'head2' now points to the head of the reversed second half

        // Step 3: Merge the two halves alternately
        Node first = head;
        Node second = head2;
        
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            // Connect first node to second node
            first.next = second;
            // Connect second node to the original next of first
            second.next = temp1;

            // Move pointers forward
            first = temp1;
            second = temp2;
        }
    }
}