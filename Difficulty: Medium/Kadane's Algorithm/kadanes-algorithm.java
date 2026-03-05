class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int cs = 0 ;
        int maxsum = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            cs+=arr[i];
            maxsum = Math.max(cs,maxsum);
            if(cs<0){
                cs=0;
            }
        }
        
        return maxsum;
    }
}
