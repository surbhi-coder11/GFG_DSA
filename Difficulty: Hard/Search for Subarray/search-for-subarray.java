import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;
        int m = b.length;

        // Base case: if pattern is longer than the array, no match possible
        if (m > n) {
            return result;
        }

        // Precompute the LPS (Longest Prefix Suffix) array for b[]
        int[] lps = computeLPSArray(b);

        int i = 0; // index for a[]
        int j = 0; // index for b[]

        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }

            if (j == m) {
                // Found a match! Add the starting index
                result.add(i - j);
                // Reset j using the LPS array to find the next possible match
                j = lps[j - 1];
            } else if (i < n && a[i] != b[j]) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPSArray(int[] b) {
        int m = b.length;
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}