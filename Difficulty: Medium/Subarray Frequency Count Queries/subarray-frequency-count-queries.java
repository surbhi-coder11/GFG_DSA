import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Map to store the list of indices for each element
        Map<Integer, ArrayList<Integer>> elementIndicesMap = new HashMap<>();
        
        // Populate the map with sorted indices
        for (int i = 0; i < arr.length; i++) {
            elementIndicesMap.putIfAbsent(arr[i], new ArrayList<>());
            elementIndicesMap.get(arr[i]).add(i);
        }
        
        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            
            // If the element doesn't exist in the array, frequency is 0
            if (!elementIndicesMap.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            ArrayList<Integer> indices = elementIndicesMap.get(x);
            
            // Find the count of indices between l and r inclusive
            int count = countRange(indices, l, r);
            result.add(count);
        }
        
        return result;
    }
    
    // Helper method to count how many elements in the list are within [l, r]
    private int countRange(ArrayList<Integer> list, int l, int r) {
        // Find upper bound for 'r' (first element strictly greater than r)
        int rightIndex = upperBound(list, r);
        
        // Find lower bound for 'l' (first element greater than or equal to l)
        int leftIndex = lowerBound(list, l);
        
        return rightIndex - leftIndex;
    }
    
    // Returns the index of the first element strictly greater than key
    private int upperBound(ArrayList<Integer> list, int key) {
        int idx = Collections.binarySearch(list, key);
        if (idx >= 0) {
            // Element found, we want the position right after its last occurrence
            // Since indices are unique, it's just idx + 1
            return idx + 1;
        } else {
            // Element not found, returns (-(insertion point) - 1)
            return -(idx + 1);
        }
    }
    
    // Returns the index of the first element greater than or equal to key
    private int lowerBound(ArrayList<Integer> list, int key) {
        int idx = Collections.binarySearch(list, key);
        if (idx >= 0) {
            // Element found
            return idx;
        } else {
            // Element not found, returns the insertion point
            return -(idx + 1);
        }
    }
}