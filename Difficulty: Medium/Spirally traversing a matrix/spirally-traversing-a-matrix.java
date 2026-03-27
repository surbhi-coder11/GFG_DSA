class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        int n = mat.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int m = mat[0].length;
        int rowl = 0;
        int rowh = mat.length-1;
        int coll = 0;
        int colh=mat[0].length-1;
        int count=0;
        while(rowl<=rowh && coll<=colh){
            for(int i=coll;i<=colh;i++){
                ans.add(mat[rowl][i]);
                
            }
            rowl++;
            for(int i=rowl;i<=rowh;i++){
                ans.add(mat[i][colh]);
                count++;
            }
            colh--;
            if(rowl<=rowh){
            for(int i=colh;i>=coll ;i--){
                ans.add(mat[rowh][i]);
                count++;
            }
            rowh--;
            }
            if(coll<=colh){
            for(int i=rowh;i>=rowl ;i--){
                ans.add(mat[i][coll]);
                count++;
            }
            coll++;
            }
        }
        return ans;
        
    }
}
