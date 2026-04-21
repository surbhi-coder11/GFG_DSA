class Solution {
    public int minSteps(int m, int n, int d) {
        // Basic feasibility checks
        if (d > Math.max(m, n)) return -1;
        if (d % gcd(m, n) != 0) return -1;

        // Return the minimum steps between starting with Jug M or Jug N
        return Math.min(solve(m, n, d), solve(n, m, d));
    }

    private int solve(int fromCap, int toCap, int target) {
        int from = fromCap; // Fill the first jug
        int to = 0;
        int steps = 1; // Step 1: Initial fill

        while (from != target && to != target) {
            // Find the maximum amount we can pour
            int temp = Math.min(from, toCap - to);

            // Pour from 'from' to 'to'
            to += temp;
            from -= temp;
            steps++;

            if (from == target || to == target) break;

            // If first jug becomes empty, fill it
            if (from == 0) {
                from = fromCap;
                steps++;
            }

            // If second jug becomes full, empty it
            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}