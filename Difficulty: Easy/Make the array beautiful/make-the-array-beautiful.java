import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static List<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (int num : arr) {
            if (st.isEmpty()) {
                st.push(num);
            } else {
                // Check if the top of the stack and the current number have different signs
                if ((st.peek() < 0 && num >= 0) || (st.peek() >= 0 && num < 0)) {
                    st.pop(); // Remove the adjacent pair
                } else {
                    st.push(num); // Same sign, add to stack
                }
            }
        }
        
        // Convert the stack into the required List format
        return new ArrayList<>(st);
    }
}