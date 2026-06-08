/* Structure of linked list node 
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} */

class Solution {
    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Reverse the linked list
        head = reverse(head);
        
        // Step 2: Traverse and delete nodes smaller than the max seen so far
        Node current = head;
        Node maxNode = head;
        
        while (current != null && current.next != null) {
            // If the next node is smaller than the maxNode, skip/delete it
            if (current.next.data < maxNode.data) {
                current.next = current.next.next;
            } else {
                // Otherwise, move current forward and update the maxNode
                current = current.next;
                maxNode = current;
            }
        }
        
        // Step 3: Reverse the list again to restore the original order
        head = reverse(head);
        
        return head;
    }
    
    // Helper function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}