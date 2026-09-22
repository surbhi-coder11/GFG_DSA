import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        char[] sArr = s.toCharArray(); // Convert to char array once for fast access

        for (String word : d) {
            int wLen = word.length();
            int rLen = result.length();

            // Pruning: Skip if word is shorter than current result
            if (wLen < rLen) {
                continue;
            }

            // Pruning: If same length, skip if word is lexicographically larger or equal
            if (wLen == rLen && word.compareTo(result) >= 0) {
                continue;
            }

            // Check if word is a subsequence
            if (isSubsequence(word, sArr)) {
                result = word;
            }
        }

        return result;
    }

    private boolean isSubsequence(String word, char[] sArr) {
        int i = 0;
        int j = 0;
        int wLen = word.length();
        int sLen = sArr.length;

        while (i < wLen && j < sLen) {
            if (word.charAt(i) == sArr[j]) {
                i++;
            }
            j++;
        }

        return i == wLen;
    }
}