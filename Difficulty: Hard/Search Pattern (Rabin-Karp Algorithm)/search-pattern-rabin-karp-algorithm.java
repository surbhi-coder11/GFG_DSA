import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int n = text.length();
        int m = pattern.length();
        
        // If the pattern is longer than the text, it can't exist in it
        if (m > n) {
            return result;
        }
        
        // d is the number of characters in the input alphabet (lowercase English)
        int d = 26;
        // q is a prime number to compute modular hashes without overflow
        int q = 101; 
        
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;
        
        // The value of h would be "pow(d, m-1) % q"
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }
        
        // Calculate the initial hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + (pattern.charAt(i) - 'a')) % q;
            t = (d * t + (text.charAt(i) - 'a')) % q;
        }
        
        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            
            // If the hash values match, then check the characters one by one
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                
                // If p == t and pattern[0...m-1] = text[i...i+m-1]
                if (j == m) {
                    result.add(i);
                }
            }
            
            // Calculate hash value for the next window of text:
            // Remove leading digit, add trailing digit
            if (i < n - m) {
                t = (d * (t - (text.charAt(i) - 'a') * h) + (text.charAt(i + m) - 'a')) % q;
                
                // We might get a negative value for t, converting it to positive
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
        
        return result;
    }
}