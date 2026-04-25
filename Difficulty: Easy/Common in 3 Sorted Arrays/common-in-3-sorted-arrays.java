class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length && k < c.length) {
            // Found a common element
            if (a[i] == b[j] && b[j] == c[k]) {
                // Handle duplicates: only add if result is empty or 
                // if the element is different from the last added element
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
                k++;
            } 
            // If a[i] is smaller, it can't be common with current b[j] or c[k]
            else if (a[i] < b[j]) {
                i++;
            } 
            // If b[j] is smaller, move it forward
            else if (b[j] < c[k]) {
                j++;
            } 
            // Otherwise, c[k] must be the smallest or equal to others
            else {
                k++;
            }
        }
        
        return result;
    }
}