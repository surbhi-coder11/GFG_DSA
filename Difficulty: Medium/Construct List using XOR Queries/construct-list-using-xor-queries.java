import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int cumulativeXor = 0;
        
        // Step 1: Process queries from right to left (backward)
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int val = queries[i][1];
            
            if (type == 1) {
                // Accumulate the XOR value for all previous elements
                cumulativeXor ^= val;
            } else {
                // Inserted element gets XORed with all subsequent type-1 query values
                result.add(val ^ cumulativeXor);
            }
        }
        
        // Step 2: The initial element '0' undergoes all type-1 XOR queries
        result.add(0 ^ cumulativeXor);
        
        // Step 3: Sort the final list as required by the problem statement
        Collections.sort(result);
        
        return result;
    }
}