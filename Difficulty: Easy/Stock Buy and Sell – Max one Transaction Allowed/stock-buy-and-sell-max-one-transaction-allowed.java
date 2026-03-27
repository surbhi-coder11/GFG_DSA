class Solution {
    public int maxProfit(int[] arr) {
        // Code here
        int maxprofit = 0;
        int buy = arr[0];
        for(int i=1;i<arr.length;i++){
            if(buy<arr[i]){
                int curr = arr[i] - buy;
                maxprofit = Math.max(curr,maxprofit);
            }
            else{
                buy = arr[i];
            }
        }
        
        return maxprofit;
    }
}