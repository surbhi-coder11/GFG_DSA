class Solution {
    static int isPatternPresent(String S, String P) {
        // Case 1: Pattern is preceded by '^'
        if (P.startsWith("^")) {
            String remainingPattern = P.substring(1);
            if (S.startsWith(remainingPattern)) {
                return 1;
            }
            return 0;
        }
        
        // Case 2: Pattern is succeeded by '$'
        if (P.endsWith("$")) {
            String remainingPattern = P.substring(0, P.length() - 1);
            if (S.endsWith(remainingPattern)) {
                return 1;
            }
            return 0;
        }
        
        // Case 3: No markers, check if P is a substring of S
        if (S.contains(P)) {
            return 1;
        }
        
        return 0;
    }
}