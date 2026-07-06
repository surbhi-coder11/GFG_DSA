class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int i = 0, j = 0;
        int n = a.length;
        int m = b.length;
        
        int result = 0;
        int sumA = 0;
        int sumB = 0;
        
        // Traverse both arrays
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sumA += a[i++];
            } else if (b[j] < a[i]) {
                sumB += b[j++];
            } else { 
                // Common element encountered
                // Add the maximum sum path reached so far plus the common element
                result += Math.max(sumA, sumB) + a[i];
                
                // Reset running sums for the next segment
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }
        
        // Collect remaining elements of array a[] if any
        while (i < n) {
            sumA += a[i++];
        }
        
        // Collect remaining elements of array b[] if any
        while (j < m) {
            sumB += b[j++];
        }
        
        // Add the final remaining maximum path segment
        result += Math.max(sumA, sumB);
        
        return result;
    }
}