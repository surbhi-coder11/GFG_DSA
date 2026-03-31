class Solution {
    public int maxProfit(int arr[], int fee) {
        // Code here
         int n = arr.length;

        int hold = -arr[0]; // profit when holding stock
        int cash = 0;       // profit when not holding stock

        for (int i = 1; i < n; i++) {
            int prevCash = cash;

            // Sell stock
            cash = Math.max(cash, hold + arr[i] - fee);

            // Buy stock
            hold = Math.max(hold, prevCash - arr[i]);
        }

        return cash;
    }
}