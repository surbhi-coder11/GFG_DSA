import java.util.*;

class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        if (n < 3) return result;

        // Array to store the index of the smallest element on the left side of arr[i]
        int[] leftSmall = new int[n];
        leftSmall[0] = -1; // No element to the left of the first element
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[minIndex]) {
                minIndex = i;
                leftSmall[i] = -1;
            } else {
                leftSmall[i] = minIndex;
            }
        }

        // Array to store the index of the largest element on the right side of arr[i]
        int[] rightGreater = new int[n];
        rightGreater[n - 1] = -1; // No element to the right of the last element
        int maxIndex = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
                rightGreater[i] = -1;
            } else {
                rightGreater[i] = maxIndex;
            }
        }

        // Find an index i such that it has both a leftSmall and a rightGreater
        for (int i = 0; i < n; i++) {
            if (leftSmall[i] != -1 && rightGreater[i] != -1) {
                result.add(arr[leftSmall[i]]);
                result.add(arr[i]);
                result.add(arr[rightGreater[i]]);
                return result;
            }
        }

        return result; // Return empty list if no such triplet exists
    }
}