import java.util.Stack;

class Solution {
    public int sumOfMax(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Find the immediate greater element on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no greater element on the left; boundary is -1
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear stack to reuse for the right side
        stack.clear();
        
        // Step 2: Find the immediate greater or equal element on the right
        for (int i = n - 1; i >= 0; i--) {
            // Using strict minor (<) here to avoid duplicate counting of equal elements
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            // If stack is empty, no greater element on the right; boundary is n
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Step 3: Compute total contribution of each element
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - left[i];
            long rightCount = right[i] - i;
            long totalSubarrays = leftCount * rightCount;
            
            totalSum += totalSubarrays * arr[i];
        }
        
        // The problem statement guarantees the answer fits in a 32-bit signed integer
        return (int) totalSum;
    }
}