// User function Template for Java

class Solution {
    private long countpair(int n){
        if(n==1 || n==2){
            return n;
        }
        long fn1 = countpair(n-1);
        long fn2 = (n-1)*countpair(n-2);
        return fn1+fn2;
        
    }
    public long countFriendsPairings(int n) {
        // code here
        return countpair(n);
    }
}
