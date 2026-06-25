import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Base case: If n is 1, single digits 0-9 are all valid
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        // If n > 9, it's impossible to have strictly increasing digits
        if (n > 9) {
            return result;
        }
        
        // Start backtracking: first digit can be anywhere from 1 to 9
        findNumbers(n, 1, 0, result);
        
        return result;
    }
    
    private static void findNumbers(int n, int startDigit, int currentNum, ArrayList<Integer> result) {
        // If the number reaches n digits, add it to the result list
        if (n == 0) {
            result.add(currentNum);
            return;
        }
        
        // Try placing digits that are strictly greater than the previous digit
        for (int i = startDigit; i <= 9; i++) {
            // Append the digit to the current number
            int nextNum = currentNum * 10 + i;
            
            // Recursively find the next digit, ensuring it's greater than 'i'
            findNumbers(n - 1, i + 1, nextNum, result);
        }
    }
}