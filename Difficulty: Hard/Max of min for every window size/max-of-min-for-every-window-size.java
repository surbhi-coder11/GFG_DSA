import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Find previous smaller element for every element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear stack to reuse it
        stack.clear();
        
        // Step 2: Find next smaller element for every element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Step 3: Create an auxiliary array to store answers for window sizes
        // ans[i] will store maximum of minimum for window size i
        int[] ans = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            // Length of the window where arr[i] is the minimum
            int len = right[i] - left[i] - 1;
            
            // Maximize the value for this specific window size
            ans[len] = Math.max(ans[len], arr[i]);
        }
        
        // Step 4: Fill entries that are not filled yet
        // A larger window's minimum cannot be greater than a smaller window's minimum
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        // Step 5: Convert the 1-based ans array to the expected ArrayList format
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(ans[i]);
        }
        
        return result;
    }
}