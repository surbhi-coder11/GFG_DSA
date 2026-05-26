class Solution {
    public static int minToggle(int[] arr) {
        int oneCount = 0;
        int toggle = 0;
        
        for (int num : arr) {
            if (num == 1) {
                // Track 1s encountered so far
                oneCount++;
            } else {
                // If it's a 0, choose the minimum cost path:
                // 1. Flip this 0 into a 1 -> (toggle + 1)
                // 2. Flip all previous 1s into 0s -> (oneCount)
                toggle = Math.min(toggle + 1, oneCount);
            }
        }
        
        return toggle;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 0, 1, 1, 0};
        System.out.println("Minimum toggles: " + minToggle(arr1)); // Output: 2

        // Test Case 2
        int[] arr2 = {0, 1, 0, 0, 1, 1, 1};
        System.out.println("Minimum toggles: " + minToggle(arr2)); // Output: 1
    }
}