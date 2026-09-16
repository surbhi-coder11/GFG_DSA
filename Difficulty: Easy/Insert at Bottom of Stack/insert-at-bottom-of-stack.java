import java.util.Stack;
class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        if(st.isEmpty()){
            st.push(x);
            return st;
        }
        // code here
        int top = st.pop();
        insertAtBottom(st,x);
        st.push(top);
        
        return st;
    }
}