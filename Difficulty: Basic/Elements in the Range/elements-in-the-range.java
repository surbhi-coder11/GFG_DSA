import java.util.HashSet;

class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements of the array to the hash set
        for (int num : arr) {
            set.add(num);
        }
        
        // Check if every element in the range [start, end] is present
        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        
        return true;
    }
}