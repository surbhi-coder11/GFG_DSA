class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low>=high){
            return;
        }
        int pividx = partition(arr,low,high);
        quickSort(arr,low,pividx-1);
        quickSort(arr,pividx+1,high);
    }

    private int partition(int[] arr, int low, int high) {
        
        // code here
        int i= low-1;
        int pivot = arr[high];
        for(int j=low;j<=high;j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot ;
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }
}