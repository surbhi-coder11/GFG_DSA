import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        // Deque to store indices of array elements
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < arr.length; i++) {
            // 1. Remove elements that are out of the current window range
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // 2. Remove elements from the back that are smaller than the current element
            // because they will never be the maximum in this or future windows
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            
            // 3. Add the current element's index to the back of the deque
            deque.offerLast(i);
            
            // 4. The first window ends at index k - 1. Post that, add the max to the result
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }
        
        return result;
    }
}