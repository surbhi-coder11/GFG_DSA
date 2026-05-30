class Solution {
    // Helper function to calculate the sum of squares of digits
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }

    static int isHappy(int N) {
        int tortoise = N;
        int hare = getNext(N);

        // Move tortoise by 1 step and hare by 2 steps
        while (hare != 1 && tortoise != hare) {
            tortoise = getNext(tortoise);
            hare = getNext(getNext(hare));
        }

        // If hare reaches 1, it's a happy number
        return hare == 1 ? 1 : 0;
    }
}