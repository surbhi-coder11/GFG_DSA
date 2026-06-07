class Solution {
    public String profession(int level, int pos) {
        // Count the number of set bits (1s) in (pos - 1)
        int setBits = Integer.bitCount(pos - 1);
        
        // If the count of 1s is even, it's an Engineer. Otherwise, it's a Doctor.
        if (setBits % 2 == 0) {
            return "Engineer";
        } else {
            return "Doctor";
        }
    }
}