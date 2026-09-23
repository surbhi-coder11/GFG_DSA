import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        // Deque to store indices in monotonic decreasing order of values
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window [i - k + 1, i]
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove indices of smaller elements from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // 3. Add current element's index
            dq.offerLast(i);

            // 4. The front of deque is the maximum for window ending at i
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }

        return result;
    }
}