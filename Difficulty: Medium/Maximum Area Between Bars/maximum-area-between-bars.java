class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        long ans = 0;

        while (left < right) {
            long area = (long) Math.min(height.get(left), height.get(right))
                        * (right - left - 1);

            ans = Math.max(ans, area);

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return (int) ans;
    }
}