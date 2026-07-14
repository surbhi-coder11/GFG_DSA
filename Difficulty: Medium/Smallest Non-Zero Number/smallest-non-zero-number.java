class Solution {
    public int find(int[] arr) {
        // We start from the end. At the very end, x must be at least 0.
        long currentX = 0; 
        
        // Traverse the array backwards
        for (int i = arr.length - 1; i >= 0; i--) {
            // Reverse operation: ceiling of (currentX + arr[i]) / 2
            currentX = (currentX + arr[i] + 1) / 2;
        }
        
        // The problem asks for the smallest non-zero number.
        // If our calculated required starting x is 0, we must return 1.
        return currentX == 0 ? 1 : (int) currentX;
    }
}