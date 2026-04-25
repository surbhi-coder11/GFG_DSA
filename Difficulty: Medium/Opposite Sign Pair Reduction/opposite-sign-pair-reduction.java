import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int val : arr) {
            boolean currentDestroyed = false;

            // Check for opposite signs: (top > 0 and val < 0) OR (top < 0 and val > 0)
            while (!stack.isEmpty() && ((stack.peek() > 0 && val < 0) || (stack.peek() < 0 && val > 0))) {
                int topAbs = Math.abs(stack.peek());
                int valAbs = Math.abs(val);

                if (topAbs < valAbs) {
                    // Top is smaller, remove it and keep checking val against next stack element
                    stack.pop();
                } else if (topAbs == valAbs) {
                    // Both are equal, both are destroyed
                    stack.pop();
                    currentDestroyed = true;
                    break;
                } else {
                    // Top is larger, current val is destroyed
                    currentDestroyed = true;
                    break;
                }
            }

            if (!currentDestroyed) {
                stack.push(val);
            }
        }

        return new ArrayList<>(stack);
    }
}