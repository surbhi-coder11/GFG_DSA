class Solution {
    public int maxCharGap(String s) {
        // Array to store the first occurrence index of each character 'a' through 'z'
        int[] firstIndex = new int[26];
        
        // Initialize all positions with -1 to indicate they haven't been seen yet
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }
        
        int maxGap = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int alphabetIndex = ch - 'a';
            
            // If the character is seen for the first time, record its index
            if (firstIndex[alphabetIndex] == -1) {
                firstIndex[alphabetIndex] = i;
            } else {
                // If seen before, calculate the gap and update maxGap
                int currentGap = i - firstIndex[alphabetIndex] - 1;
                maxGap = Math.max(maxGap, currentGap);
            }
        }
        
        return maxGap;
    }
}