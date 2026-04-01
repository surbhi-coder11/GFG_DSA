
// class Node {
//     int data;
//     Node next;

//     Node(int x) {
//         data = x;
//         next = null;
//     }
// }


class Solution {
    public Node insertAtFront(Node head, int x) {
        // code here
        Node key = new Node( x);
        key.next = head;
        head = key;
        Node temp = head;
        // while(temp!=null){
        //     System.out.print(temp.data+"->");
        //     temp = temp.next;
        // }
        return head;
        
    }
}