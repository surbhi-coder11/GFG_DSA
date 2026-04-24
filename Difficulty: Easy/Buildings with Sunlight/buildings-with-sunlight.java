class Solution {
    public int visibleBuildings(int arr[]) {
        // If there are no buildings, return 0
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // The first building always receives sunlight
        int count = 1;
        int currentMax = arr[0];

        // Traverse the buildings starting from the second one
        for (int i = 1; i < arr.length; i++) {
            // If the current building is taller than or equal to 
            // the tallest building seen so far, it gets sunlight
            if (arr[i] >= currentMax) {
                count++;
                currentMax = arr[i];
            }
        }

        return count;
    }
}