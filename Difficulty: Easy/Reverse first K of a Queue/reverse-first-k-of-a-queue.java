import java.util.*;
class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if (q == null || q.isEmpty() || k <= 0 || k > q.size()) {
                    return q;
                }
        int n = q.size();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<k;i++){
            st.push(q.remove());
        }
        
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        
        for(int i=0;i<n-k;i++){
            q.add(q.remove());
        }
        
        return q;
    }
}