import java.util.*;
class Solution {
    public String firstNonRepeating(String s) {
        // code here
        StringBuilder str = new StringBuilder("");
        Deque<Character> q = new ArrayDeque<>();
        int[]  freq = new int[26];
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            
            if(q.isEmpty()){
                str.append('#');
            }
            else{
                str.append(q.peek());
            }
        }
        
        return str.toString();
    }
}