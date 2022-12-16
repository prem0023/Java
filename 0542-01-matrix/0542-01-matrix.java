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