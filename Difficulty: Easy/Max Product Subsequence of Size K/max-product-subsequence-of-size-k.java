import java.util.Arrays;

class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int product = 1;

        // If k is odd and all numbers are non-positive (arr[n-1] <= 0),
        // pick the largest k numbers (closest to 0) from the right end
        if (arr[n - 1] <= 0 && k % 2 != 0) {
            for (int i = n - 1; i >= n - k; i--) {
                product *= arr[i];
            }
            return product;
        }

        int i = 0, j = n - 1;

        // If k is odd, take the largest positive element first
        if (k % 2 != 0) {
            product *= arr[j];
            j--;
            k--;
        }

        // Compare pairs from the left (negative numbers) and right (positive numbers)
        while (k > 0) {
            int leftProduct = arr[i] * arr[i + 1];
            int rightProduct = arr[j] * arr[j - 1];

            if (leftProduct > rightProduct) {
                product *= leftProduct;
                i += 2;
            } else {
                product *= rightProduct;
                j -= 2;
            }
            k -= 2;
        }

        return product;
    }
}