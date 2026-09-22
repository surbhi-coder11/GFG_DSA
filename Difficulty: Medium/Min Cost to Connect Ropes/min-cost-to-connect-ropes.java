
import java.util.*;
class Solution {
    public int minCost(int[] arr) {
        if(arr.length == 0 || arr.length == 1){
            return 0;
        }
        // code here
        int cost = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);
        }
        
        while(q.size()>1){
            int f = q.remove();
            int l = q.remove();
            
            int costnow=f+l;
            cost+=costnow;
            q.add(costnow);
        }
        
        return cost;
    }
}