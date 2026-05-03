import java.util.*;

class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            list.add(num);
        }
        
        Collections.sort(list, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA != countB) {
                return countB - countA; // descending by set bits
            }
            return 0; // stable order
        });
        
        return list;
    }
}
