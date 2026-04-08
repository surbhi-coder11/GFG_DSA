class Solution {
    void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Move left pointer until we find a 1
            while (arr[left] == 0 && left < right) {
                left++;
            }

            // Move right pointer until we find a 0
            while (arr[right] == 1 && left < right) {
                right--;
            }

            // Swap the 1 at left with the 0 at right
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}