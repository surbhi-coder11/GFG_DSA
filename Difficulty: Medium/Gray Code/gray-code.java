class Solution {
    public ArrayList<String> graycode(int n) {
        // Base case: n = 1
        if (n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }

        // Recursive call to get (n-1) bit codes
        ArrayList<String> previousRes = graycode(n - 1);
        ArrayList<String> currentRes = new ArrayList<>();

        // Step 1: Add "0" prefix to the previous results (original order)
        for (int i = 0; i < previousRes.size(); i++) {
            currentRes.add("0" + previousRes.get(i));
        }

        // Step 2: Add "1" prefix to the previous results (reversed order/reflected)
        for (int i = previousRes.size() - 1; i >= 0; i--) {
            currentRes.add("1" + previousRes.get(i));
        }

        return currentRes;
    }
}