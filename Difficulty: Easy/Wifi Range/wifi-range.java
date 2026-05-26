class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        // Tracks the rightmost index covered by WiFi so far
        int maxCovered = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // The current router covers from (i - x) to (i + x)
                int leftReach = i - x;
                int rightReach = i + x;

                // If there is a gap between the last covered room and this router's left reach
                if (leftReach > maxCovered + 1) {
                    return false;
                }

                // Update the maximum covered range
                maxCovered = Math.max(maxCovered, rightReach);
            }
        }

        // Check if the coverage extends to at least the last room
        return maxCovered >= n - 1;
    }
}