import java.util.Stack;
class Solution {
    public String reverse(String S) {
        // code here
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<S.length()){
            st.push(S.charAt(i));
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        
        while(!st.isEmpty()){
            char ch = st.pop();
            sb.append(ch);
        }
        
        String res = sb.toString();
        return res;
        
    }
}