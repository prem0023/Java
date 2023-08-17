class Solution 
{
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length, INF = m + n; // The distance of cells is up to (M+N)
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) continue;
                int top = INF, left = INF;
                if (r - 1 >= 0) top = mat[r - 1][c];
                if (c - 1 >= 0) left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] == 0) continue;
                int bottom = INF, right = INF;
                if (r + 1 < m) bottom = mat[r + 1][c];
                if (c + 1 < n) right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}

/*
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    visited[i][j] = true;
                    queue.offer(new Pair(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            int i = queue.peek().x;
            int j = queue.poll().y;

            if(i>0 && !visited[i-1][j]){
                visited[i-1][j] = true;
                ans[i-1][j] = ans[i][j]+1;
                queue.offer(new Pair(i-1, j));
            }
            if(i+1<n && !visited[i+1][j]){
                visited[i+1][j] = true;
                ans[i+1][j] = ans[i][j]+1;
                queue.offer(new Pair(i+1, j));
            }
            if(j>0 && !visited[i][j-1]){
                visited[i][j-1] = true;
                ans[i][j-1] = ans[i][j]+1;
                queue.offer(new Pair(i, j-1));
            }
           if(j+1<m && !visited[i][j+1]){
                visited[i][j+1] = true;
                ans[i][j+1] = ans[i][j]+1;
                queue.offer(new Pair(i, j+1));
           }
        }
        return ans;
    }
}
*/