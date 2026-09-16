/* Structure of Linked List Node
class Node
{
  int data;
  Node next;
  Node(int data)
  {
      this.data = data;
      this.next = null;
  }
}*/

class Solution {
    static void linkDelete(Node head, int n, int m) {
        // code here
         Node curr = head;
        while(curr!=null){
    
        for(int count =1; count<m && curr!=null ; count++){
            curr = curr.next;
        }
        if(curr == null){
            return;
        }
        
        Node temp = curr.next;
        
        for(int i=1;i<=n && temp!=null;i++){
            temp= temp.next;
        }
        curr.next = temp;
        curr= temp;
        }
    }
}