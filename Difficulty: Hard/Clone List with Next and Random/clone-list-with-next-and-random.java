/* class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
} */

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        
        // Step 1: Create clone nodes and insert them next to original nodes
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            Node cloneNode = new Node(curr.data);
            
            curr.next = cloneNode;
            cloneNode.next = nextNode;
            
            curr = nextNode;
        }
        
        // Step 2: Assign random pointers for the clone nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            // Move to the next original node
            curr = curr.next.next;
        }
        
        // Step 3: Separate the original list and the cloned list
        curr = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;
        
        while (curr != null) {
            curr.next = curr.next.next;
            if (cloneCurr.next != null) {
                cloneCurr.next = cloneCurr.next.next;
            }
            
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }
        
        return cloneHead;
    }
}