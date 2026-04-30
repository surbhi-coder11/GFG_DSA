class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        
        // We only need to check internal nodes. 
        // Nodes from (n/2) to n-1 are leaf nodes and have no children.
        for (int i = 0; i <= (n - 2) / 2; i++) {
            
            // Check left child
            int leftChild = 2 * i + 1;
            if (leftChild < n && arr[i] < arr[leftChild]) {
                return false;
            }
            
            // Check right child
            int rightChild = 2 * i + 2;
            if (rightChild < n && arr[i] < arr[rightChild]) {
                return false;
            }
        }
        
        return true;
    }
}