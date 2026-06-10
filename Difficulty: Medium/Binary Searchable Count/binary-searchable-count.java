class Solution {
    public int binarySearchable(int[] arr) {
        return solve(arr, 0, arr.length - 1,
                     Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private int solve(int[] arr, int l, int r,
                      long low, long high) {
        if (l > r) return 0;

        int mid = (l + r) / 2;
        int count = 0;

        if (arr[mid] > low && arr[mid] < high) {
            count = 1;
        }

        count += solve(arr, l, mid - 1, low,
                       Math.min(high, arr[mid]));

        count += solve(arr, mid + 1, r,
                       Math.max(low, arr[mid]), high);

        return count;
    }
}