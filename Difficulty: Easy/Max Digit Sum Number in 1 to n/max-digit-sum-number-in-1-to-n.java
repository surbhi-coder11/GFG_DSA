class Solution {
    public int findMax(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int len = s.length;

        int maxNum = n;
        int maxSum = getDigitSum(n);

        // Try changing digits from right to left
        for (int i = len - 1; i >= 0; i--) {
            // If digit is '0', decreasing it makes it invalid without borrowing
            if (s[i] == '0') continue;

            // Create candidate by subtracting 1 from digit i
            char[] cand = s.clone();
            cand[i]--;

            // Fill all digits to the right with '9'
            for (int j = i + 1; j < len; j++) {
                cand[j] = '9';
            }

            int candidateVal = Integer.parseInt(new String(cand));
            int candidateSum = getDigitSum(candidateVal);

            // Update if strictly greater digit sum, or same sum with a larger value
            if (candidateSum > maxSum) {
                maxSum = candidateSum;
                maxNum = candidateVal;
            } else if (candidateSum == maxSum) {
                maxNum = Math.max(maxNum, candidateVal);
            }
        }

        return maxNum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}