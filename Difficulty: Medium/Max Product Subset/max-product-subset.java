class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        
        // Edge case: If there's only 1 element, it's the maximum product subset by default
        if (n == 1) {
            return arr[0];
        }

        long maxProd = 1;
        int maxNegative = Integer.MIN_VALUE;
        int negativeCount = 0;
        int zeroCount = 0;
        int positiveCount = 0;
        long MOD = 1000000007;

        for (int i = 0; i < n; i++) {
            // If the element is 0, skip it for the product calculation
            if (arr[i] == 0) {
                zeroCount++;
                continue;
            }

            // Track negative numbers and find the largest negative (closest to 0)
            if (arr[i] < 0) {
                negativeCount++;
                maxNegative = Math.max(maxNegative, arr[i]);
            } else {
                positiveCount++;
            }

            // Cumulate the product with modulo
            maxProd = (maxProd * arr[i]) % MOD;
        }

        // Case 1: If all elements are zeros
        if (zeroCount == n) {
            return 0;
        }

        // Case 2: If there is an odd number of negative elements
        if (negativeCount % 2 != 0) {
            // Special sub-case: If there is only 1 negative element, no positives, and some zeros
            // e.g., [-3, 0, 0] -> Max subset product is 0 (by choosing subset {0})
            if (negativeCount == 1 && positiveCount == 0 && zeroCount > 0) {
                return 0;
            }
            
            // Otherwise, remove the largest negative number from the cumulative product
            // To "divide" out maxNegative in modular arithmetic safely, we re-handle negative numbers
            // or we can simply adjust the product. Since maxNegative is negative, we handle the sign:
            maxProd = (maxProd / maxNegative);
        }

        // Ensure the result is positive if it somehow became negative during adjustments
        if (maxProd < 0) {
            maxProd += MOD;
        }

        return (int) maxProd;
    }
}