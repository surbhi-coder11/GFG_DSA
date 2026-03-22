class Solution {
    public int orangesRot(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges & count fresh
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if(fresh == 0) return 0;

        int time = 0;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Step 2: BFS
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if(rotted) time++; // increase only if something rotted
        }

        return fresh == 0 ? time : -1;
    }
}