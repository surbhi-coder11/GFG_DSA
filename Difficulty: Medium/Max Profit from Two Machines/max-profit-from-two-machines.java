import java.util.*;

class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        // Store the difference (a[i] - b[i]) along with the original index
        // or simply pair the values to sort them.
        Pair[] diff = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            diff[i] = new Pair(a[i], b[i]);
        }
        
        // Sort based on the profit difference (a - b) in descending order
        Arrays.sort(diff, (p1, p2) -> (p2.a - p2.b) - (p1.a - p1.b));
        
        int totalProfit = 0;
        
        // We want to give tasks to Machine A where (a - b) is largest.
        // However, we must ensure Machine B has enough capacity for the remaining tasks.
        // Since x + y >= n, we can always finish all tasks.
        
        for (int i = 0; i < n; i++) {
            // If Machine A still has capacity AND 
            // (Machine B capacity is tight OR Machine A is more profitable)
            if (x > 0 && (n - i > y || (diff[i].a >= diff[i].b))) {
                totalProfit += diff[i].a;
                x--;
            } else {
                totalProfit += diff[i].b;
                y--;
            }
        }
        
        return totalProfit;
    }
    
    // Helper class to keep track of individual task profits
    class Pair {
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}