class Solution {
    public static String countSort(String s) {
        // code here
        int[] freq = new int[27];
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        String ans = "";
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                char ch = (char)('a'+i);
                ans+=ch;
                freq[i]--;
            }
        }
        return ans;
    }
}