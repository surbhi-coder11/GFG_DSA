class Solution {
    public int countRevPairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            
            // Count reverse pairs in left and right halves
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            
            // Count split reverse pairs across both halves
            count += countPairs(arr, low, mid, high);
            
            // Merge the two sorted halves
            merge(arr, low, mid, high);
        }
        return count;
    }

    private int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        
        // For each element in the left sorted subarray, find matching elements in the right
        for (int i = low; i <= mid; i++) {
            // Use long to prevent potential integer overflow during 2 * arr[right]
            while (right <= high && arr[i] > 2 * (long) arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        // Standard merge process
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        // Copy remaining elements of left subarray
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right subarray
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Transfer sorted elements back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}