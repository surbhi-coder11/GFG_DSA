class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int ans = -1;
        int lt =0;
        int rt = arr.length-1;
        
        while(lt<=rt){
            int mid = lt+(rt-lt)/2;
            
            if(arr[mid]==k){
               ans = mid;
               rt = mid - 1; 
            }
            else if(arr[mid]<k){
                lt=mid+1;
            }
            else{
                rt = mid-1;
            }
        }
        
        return ans;
    }
}