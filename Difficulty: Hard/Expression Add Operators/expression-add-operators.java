import java.util.ArrayList;

class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        // Start the backtracking process
        backtrack(result, s, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(ArrayList<String> result, String s, int target, int index, long calculatedVal, long prevNum, StringBuilder path) {
        // Base Case: If we reached the end of the string
        if (index == s.length()) {
            if (calculatedVal == target) {
                result.add(path.toString());
            }
            return;
        }

        int len = path.length();

        for (int i = index; i < s.length(); i++) {
            // Corner Case: Operands cannot have leading zeros (e.g., "05" is invalid, but "0" alone is fine)
            if (i != index && s.charAt(index) == '0') {
                break;
            }

            // Extract the current substring operand
            String part = s.substring(index, i + 1);
            long currentNum = Long.parseLong(part);

            // If it's the first number in the expression, we just pick it without any operator
            if (index == 0) {
                path.append(part);
                backtrack(result, s, target, i + 1, currentNum, currentNum, path);
                path.setLength(len); // Backtrack
            } else {
                // Case 1: Addition '+'
                path.append("+").append(part);
                backtrack(result, s, target, i + 1, calculatedVal + currentNum, currentNum, path);
                path.setLength(len); // Backtrack

                // Case 2: Subtraction '-'
                path.append("-").append(part);
                backtrack(result, s, target, i + 1, calculatedVal - currentNum, -currentNum, path);
                path.setLength(len); // Backtrack

                // Case 3: Multiplication '*'
                // Rule: Undo the previous operation, then multiply the previous number with the current number
                path.append("*").append(part);
                backtrack(result, s, target, i + 1, (calculatedVal - prevNum) + (prevNum * currentNum), prevNum * currentNum, path);
                path.setLength(len); // Backtrack
            }
        }
    }
}