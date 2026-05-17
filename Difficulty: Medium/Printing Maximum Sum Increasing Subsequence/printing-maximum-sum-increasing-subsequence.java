import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static List<Integer> maxSumSequence(int N, int A[]) {
        // msis[i] will store the maximum sum of increasing subsequence ending with A[i]
        int[] msis = new int[N];
        // parent[i] will store the index of the previous element in the subsequence
        int[] parent = new int[N];
        
        // Initialize arrays
        for (int i = 0; i < N; i++) {
            msis[i] = A[i];
            parent[i] = -1;
        }
        
        // Compute MSIS values and track parents
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && msis[i] < msis[j] + A[i]) {
                    msis[i] = msis[j] + A[i];
                    parent[i] = j;
                }
            }
        }
        
        // Find the index of the maximum sum
        int maxIndex = 0;
        for (int i = 1; i < N; i++) {
            // Strict inequality ensures we pick the sequence ending closest 
            // to the start if there's a tie in the maximum sum.
            if (msis[i] > msis[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // Reconstruct the sequence using the parent array
        List<Integer> result = new ArrayList<>();
        int curr = maxIndex;
        while (curr != -1) {
            result.add(A[curr]);
            curr = parent[curr];
        }
        
        // Since we reconstructed it backwards, reverse it to get the correct order
        Collections.reverse(result);
        
        return result;
    }
}