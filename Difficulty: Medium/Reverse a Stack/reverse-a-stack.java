class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverseStack(st);
        pushAtbottom(st,top);
    }
    public static void pushAtbottom(Stack<Integer> st , int key){
        if(st.isEmpty()){
            st.push(key);
            return;
        }
        
        int top = st.pop();
        pushAtbottom(st,key);
        st.push(top);
    }
}
