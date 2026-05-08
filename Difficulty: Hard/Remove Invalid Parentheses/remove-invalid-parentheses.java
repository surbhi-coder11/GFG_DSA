import java.util.*;

class Solution {
    public List<String> validParenthesis(String s) {
        int leftToRemove = 0;
        int rightToRemove = 0;

        // Step 1: Calculate the minimum number of '(' and ')' to remove
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftToRemove++;
            } else if (ch == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }

        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, 0, leftToRemove, rightToRemove, new StringBuilder(), result);
        
        // Step 2: Sort lexicographically as per requirements
        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        return sortedResult;
    }

    private void backtrack(String s, int index, int leftCount, int rightCount, 
                           int leftRem, int rightRem, StringBuilder expression, Set<String> result) {
        
        // Base Case: reached end of string
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                result.add(expression.toString());
            }
            return;
        }

        char ch = s.charAt(index);
        int len = expression.length();

        // Option 1: Discard the current character (if it's a parenthesis and we still need to remove)
        if (ch == '(' && leftRem > 0) {
            backtrack(s, index + 1, leftCount, rightCount, leftRem - 1, rightRem, expression, result);
        } else if (ch == ')' && rightRem > 0) {
            backtrack(s, index + 1, leftCount, rightCount, leftRem, rightRem - 1, expression, result);
        }

        // Option 2: Keep the current character
        expression.append(ch);
        if (ch != '(' && ch != ')') {
            // It's a letter, just move forward
            backtrack(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression, result);
        } else if (ch == '(') {
            backtrack(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression, result);
        } else if (rightCount < leftCount) {
            // Keep ')' only if it doesn't make the expression invalid
            backtrack(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression, result);
        }

        // Backtrack: remove the last added character
        expression.setLength(len);
    }
}