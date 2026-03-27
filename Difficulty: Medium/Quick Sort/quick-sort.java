class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low<=high){
            int mid = partition(arr,low,high);
        
        quickSort(arr,low,mid-1);
        quickSort(arr,mid+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        
        // code here
        int piv = arr[high];
        int i = (low-1);
        
        for(int j=low;j<high;j++){
            if(arr[j]<=piv){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        
        return i+1;
    }
}