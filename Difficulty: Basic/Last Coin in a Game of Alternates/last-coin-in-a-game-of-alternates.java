class Solution {
    public int coin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        // Continue the game until only one coin remains
        while (left < right) {
            if (arr[left] > arr[right]) {
                left++; // Left coin is larger, so it gets picked
            } else {
                right--; // Right coin is larger (or equal), so it gets picked
            }
        }
        
        // The last remaining coin
        return arr[left];
    }
}