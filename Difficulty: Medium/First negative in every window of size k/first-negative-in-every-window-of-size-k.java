import java.util.*;

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        int n = arr.length;
        
        // Step 1: Process the first window of size k
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                queue.add(i);
            }
        }
        
        // Add the first negative integer of the first window to the result
        if (!queue.isEmpty()) {
            result.add(arr[queue.peek()]);
        } else {
            result.add(0);
        }
        
        // Step 2: Slide the window from index k to n-1
        for (int i = k; i < n; i++) {
            // Remove elements that are out of the current window
            while (!queue.isEmpty() && queue.peek() <= (i - k)) {
                queue.poll();
            }
            
            // Add the current element if it's negative
            if (arr[i] < 0) {
                queue.add(i);
            }
            
            // The element at the front of the queue is the first negative in this window
            if (!queue.isEmpty()) {
                result.add(arr[queue.peek()]);
            } else {
                result.add(0);
            }
        }
        
        return result;
    }
}