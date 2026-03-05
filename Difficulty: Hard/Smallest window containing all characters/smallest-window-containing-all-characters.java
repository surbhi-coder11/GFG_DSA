class Solution {
    public static String minWindow(String s, String p) {
        // code here
         if (s.length() < p.length()) return "";

        int[] freq = new int[256];
        for (char c : p.toCharArray()) {
            freq[c]++;
        }

        int left = 0, count = p.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)] > 0) {
                count--;
            }
            freq[s.charAt(right)]--;

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}