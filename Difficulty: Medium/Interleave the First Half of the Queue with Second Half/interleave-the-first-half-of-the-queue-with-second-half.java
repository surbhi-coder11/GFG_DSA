import java.util.*;
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        int size = q.size();
        Queue<Integer> first =new LinkedList<>();
        for(int i=0;i<size/2;i++){
            first.add(q.remove());
        }
        while(!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
            
        }
        
        
        
    }
}
