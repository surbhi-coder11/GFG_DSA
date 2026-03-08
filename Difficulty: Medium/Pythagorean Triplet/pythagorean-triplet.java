class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        if(n<3){
            return false;
        }
        
        int maxval =0;
        for(int x:arr){
            if(x>maxval){
                maxval = x;
            }
        }
        
        boolean exists[] = new boolean[maxval+1];
        
        for(int x: arr){
            exists[x]=true;
        }
        
        for(int i=1;i<=maxval;i++){
            if(!exists[i]) {
                continue;
            }
            
            for(int j=i;j<=maxval;j++){
                 if(!exists[j]) {
                     continue;
                 }
                 int val = i*i + j *j;
                 
                 int c = (int) Math.sqrt(val);
                 
                 if(c*c != val || c>maxval) continue;
                 
                 if(exists[c]){
                     return true;
                 }
            }
        }
        
        return false;
        //     long[] sq = new long[n];
        // for (int i = 0; i < n; i++) {
        //     sq[i] = 1L * arr[i] * arr[i];
        // }

        // Arrays.sort(sq);

        // for (int i = n - 1; i >= 2; i--) {
        //     int l = 0, r = i - 1;
        //     long c = sq[i];

        //     while (l < r) {
        //         long sum = sq[l] + sq[r];
        //         if (sum == c) return true;
        //         if (sum < c) l++;
        //         else r--;
        //     }
        // }

        // return false;

    }
}