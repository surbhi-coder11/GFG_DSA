class Solution {
    public int findIndex(String s) {
        int totalClosing = 0;
        int n = s.length();
        
        // Count the total number of closing brackets in the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                totalClosing++;
            }
        }
        
        // The equal point index is precisely equal to the total count of ')'
        return totalClosing;
    }
}