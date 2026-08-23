class Solution {
    private static class Node {
        int r, c, u, d;

        Node(int r, int c, int u, int d) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.d = d;
        }
    }

    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Base case: starting position is out of bounds or an obstacle
        if (r < 0 || r >= n || c < 0 || c >= m || mat[r][c] == '#') {
            return 0;
        }

        // Track max remaining moves (up and down) for visited cells
        int[][] maxU = new int[n][m];
        int[][] maxD = new int[n][m];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(maxU[i], -1);
            java.util.Arrays.fill(maxD[i], -1);
        }

        java.util.Queue<Node> q = new java.util.LinkedList<>();
        q.add(new Node(r, c, u, d));
        maxU[r][c] = u;
        maxD[r][c] = d;

        int count = 0;

        // Direction vectors: Left, Right, Up, Down
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // Count newly reachable cell
            if (mat[curr.r][curr.c] == '.') {
                mat[curr.r][curr.c] = 'V'; // Mark as visited
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                int nu = curr.u;
                int nd = curr.d;

                // Check bounds and obstacle
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || mat[nr][nc] == '#') {
                    continue;
                }

                // Upward move
                if (i == 2) {
                    if (nu > 0) nu--;
                    else continue;
                }
                // Downward move
                else if (i == 3) {
                    if (nd > 0) nd--;
                    else continue;
                }

                // Push to queue if we reached this cell with strictly more remaining resources
                if (nu > maxU[nr][nc] || nd > maxD[nr][nc]) {
                    if (nu > maxU[nr][nc]) maxU[nr][nc] = nu;
                    if (nd > maxD[nr][nc]) maxD[nr][nc] = nd;
                    q.add(new Node(nr, nc, nu, nd));
                }
            }
        }

        return count;
    }
}