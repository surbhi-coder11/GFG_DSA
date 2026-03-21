class Solution {
     static int[] catalan = new int[7];
    
    static {
        catalan[0] = 1;
        catalan[1] = 1;
        
        for (int i = 2; i <= 6; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
    }
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
          int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) left++;
                else if (arr[j] > arr[i]) right++;
            }

            int ways = catalan[left] * catalan[right];
            result.add(ways);
        }

        return result;
    }
}