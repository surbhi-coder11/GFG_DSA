class Solution {

    void mergeSort(int arr[], int l, int r) {
        if(l>=r){
            return;
        }
        // code here
        int m = l+(r-l)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
    }
    
    void merge(int[] arr, int l , int m , int r){
        int[] temp = new int[r-l+1];
        int i=l;
        int j=m+1;
        int k=0;
        
        while(i<=m && j<=r){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(i<=m){
           temp[k++] = arr[i++]; 
        }
        while(j<=r){
            temp[k++] = arr[j++];
        }
        
        for(k=0,i=l;k<temp.length;i++,k++){
            arr[i] = temp[k];
        }
    }
}