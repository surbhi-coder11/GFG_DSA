class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // code here
        if(n==1 || n==0){
            return n;
        }
        //return towerOfHanoi(n-1,from,aux,to)+towerOfHanoi(n-1,from,to,aux)+towerOfHanoi(n-1,aux,from,to);
        return (int)Math.pow(2,n)-1;
    }
}
