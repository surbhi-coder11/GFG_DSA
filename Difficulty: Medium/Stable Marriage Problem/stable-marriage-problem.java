import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        
        // Final result: result[i] will store the woman matched with man i
        int[] result = new int[n];
        // wifeOfMan[i] = woman index; husbandOfWoman[j] = man index
        int[] husbandOfWoman = new int[n];
        Arrays.fill(husbandOfWoman, -1);
        
        // Pre-process women's preferences for O(1) comparison
        // rank[woman][man] = preference rank (lower is better)
        int[][] womanRank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int man = women[i][j];
                womanRank[i][man] = j;
            }
        }

        // Keep track of which woman a man should propose to next
        int[] nextProposal = new int[n];
        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            
            // Get the top choice woman that man 'm' hasn't proposed to yet
            int w = men[m][nextProposal[m]++];
            
            if (husbandOfWoman[w] == -1) {
                // Woman is free, they get engaged
                husbandOfWoman[w] = m;
                result[m] = w;
            } else {
                int currentHusband = husbandOfWoman[w];
                
                // If woman prefers man 'm' over her current husband
                if (womanRank[w][m] < womanRank[w][currentHusband]) {
                    husbandOfWoman[w] = m;
                    result[m] = w;
                    // Old husband is now free
                    freeMen.add(currentHusband);
                } else {
                    // Woman rejects man 'm', he remains free
                    freeMen.add(m);
                }
            }
        }

        return result;
    }
}