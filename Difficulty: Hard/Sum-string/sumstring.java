import java.math.BigInteger;

class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        
        // Loop for the end index of the first string
        for (int i = 1; i < n; i++) {
            // Loop for the end index of the second string
            for (int j = i + 1; j < n; j++) {
                
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);
                
                // Leading zero check: digits cannot have leading zeros unless they are exactly "0"
                if ((s1.length() > 1 && s1.charAt(0) == '0') || 
                    (s2.length() > 1 && s2.charAt(0) == '0')) {
                    continue;
                }
                
                // Check if this pair can successfully form the rest of the sum-string
                if (checkRemaining(s1, s2, j, s)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkRemaining(String s1, String s2, int k, String s) {
        // If we have successfully matched up to the exact end of the string
        if (k == s.length()) {
            return true;
        }
        
        // Use BigInteger to prevent integer overflow for large string segments
        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);
        BigInteger sum = num1.add(num2);
        String sumStr = sum.toString();
        
        // Check if the remaining string starts with the expected sum
        if (s.startsWith(sumStr, k)) {
            // Recursively move forward
            return checkRemaining(s2, sumStr, k + sumStr.length(), s);
        }
        
        return false;
    }
}