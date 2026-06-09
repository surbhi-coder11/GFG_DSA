class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        // If no people need to be seated, it's always possible
        // unless the initial seating itself is already invalid.
        // Let's first check if the initial configuration has adjacent 1s.
        for (int i = 0; i < seats.length - 1; i++) {
            if (seats[i] == 1 && seats[i + 1] == 1) {
                return false; 
            }
        }
        
        if (k == 0) {
            return true;
        }

        int count = 0;
        int n = seats.length;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                // Check if the left neighbor is empty or out of bounds
                boolean leftEmpty = (i == 0) || (seats[i - 1] == 0);
                // Check if the right neighbor is empty or out of bounds
                boolean rightEmpty = (i == n - 1) || (seats[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    seats[i] = 1; // Seat the person
                    count++;
                    
                    if (count >= k) {
                        return true;
                    }
                }
            }
        }

        return count >= k;
    }
}