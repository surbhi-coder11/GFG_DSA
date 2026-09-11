class Solution {
    public int sameMod(int[] arr) {
        int n = arr.length;
        int g = 0;

        // Calculate GCD of differences relative to arr[0]
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[0]);
            g = gcd(g, diff);
        }

        // If g remains 0, all elements in the array are equal
        if (g == 0) {
            return -1;
        }

        // Count all divisors of g
        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++; // i is a divisor
                if (i * i != g) {
                    count++; // g / i is also a divisor
                }
            }
        }

        return count;
    }

    // Helper method to compute GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}