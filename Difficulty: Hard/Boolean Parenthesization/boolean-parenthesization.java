class Solution {
    static int countWays(String s) {
        int n = s.length();
        // dpT[i][j] stores number of ways expression from i to j evaluates to true
        // dpF[i][j] stores number of ways expression from i to j evaluates to false
        int[][] dpT = new int[n][n];
        int[][] dpF = new int[n][n];

        for (int gap = 0; gap < n; gap += 2) {
            for (int i = 0, j = gap; j < n; i += 2, j += 2) {
                if (gap == 0) {
                    dpT[i][j] = (s.charAt(i) == 'T') ? 1 : 0;
                    dpF[i][j] = (s.charAt(i) == 'F') ? 1 : 0;
                } else {
                    for (int k = i + 1; k < j; k += 2) {
                        int lT = dpT[i][k - 1];
                        int lF = dpF[i][k - 1];
                        int rT = dpT[k + 1][j];
                        int rF = dpF[k + 1][j];

                        char operator = s.charAt(k);
                        if (operator == '&') {
                            dpT[i][j] += lT * rT;
                            dpF[i][j] += (lT * rF) + (lF * rT) + (lF * rF);
                        } else if (operator == '|') {
                            dpT[i][j] += (lT * rT) + (lT * rF) + (lF * rT);
                            dpF[i][j] += lF * rF;
                        } else if (operator == '^') {
                            dpT[i][j] += (lT * rF) + (lF * rT);
                            dpF[i][j] += (lT * rT) + (lF * rF);
                        }
                    }
                }
            }
        }
        return dpT[0][n - 1];
    }
}