class Solution {
    public int derangeCount(int n) {
        // Base case: n=1, derangement is 0
        if (n == 1) return 0;
        // Base case: n=2, derangement is 1
        if (n == 2) return 1;

        // Using iterative DP to store the previous two values
        // To save space, we only keep track of the last two results
        long prev2 = 0; // D(1)
        long prev1 = 1; // D(2)
        long current = 0;

        for (int i = 3; i <= n; i++) {
            // Formula: D(i) = (i - 1) * (D(i - 1) + D(i - 2))
            current = (i - 1) * (prev1 + prev2);
            
            // Update pointers for the next iteration
            prev2 = prev1;
            prev1 = current;
        }

        return (int) current;
    }
}