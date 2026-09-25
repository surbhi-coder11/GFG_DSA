import java.util.Arrays;

class Solution {

    static class Box implements Comparable<Box> {
        int h, w, l;

        Box(int h, int w, int l) {
            this.h = h;
            // Always ensure l >= w
            this.l = Math.max(w, l);
            this.w = Math.min(w, l);
        }

        @Override
        public int compareTo(Box other) {
            // Compare length first (descending)
            if (other.l != this.l) {
                return Integer.compare(other.l, this.l);
            }
            // Compare width second (descending)
            if (other.w != this.w) {
                return Integer.compare(other.w, this.w);
            }
            // Compare height last (descending)
            return Integer.compare(other.h, this.h);
        }
    }

    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        Box[] boxes = new Box[3 * n];

        // Generate all 3 rotations for each box
        for (int i = 0; i < n; i++) {
            boxes[3 * i]     = new Box(height[i], width[i], length[i]);
            boxes[3 * i + 1] = new Box(width[i], height[i], length[i]);
            boxes[3 * i + 2] = new Box(length[i], height[i], width[i]);
        }

        // Sort boxes in descending order of dimensions
        Arrays.sort(boxes);

        int totalBoxes = 3 * n;
        int[] dp = new int[totalBoxes];

        int maxHeight = 0;

        for (int i = 0; i < totalBoxes; i++) {
            dp[i] = boxes[i].h;
            for (int j = 0; j < i; j++) {
                // Check if boxes[i] can strictly fit on top of boxes[j]
                if (boxes[i].l < boxes[j].l && boxes[i].w < boxes[j].w) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i].h);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }
}