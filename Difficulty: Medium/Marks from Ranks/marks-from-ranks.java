import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        // pref[i] store total count of marks up to interval i-1
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (r[i] - l[i] + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int k : rank) {
            // Binary search to find the interval containing rank 'k'
            int low = 0, high = n - 1;
            int targetIdx = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pref[mid] < k) {
                    targetIdx = mid; // potential interval
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Calculate exact mark within the found interval
            long offset = k - pref[targetIdx] - 1;
            int mark = (int) (l[targetIdx] + offset);
            result.add(mark);
        }

        return result;
    }
}