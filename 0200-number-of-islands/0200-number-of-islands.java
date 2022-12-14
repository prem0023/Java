class Pair{
    int i, j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    DFS(visited, grid, i, j, n, m);
                }
            }
        }
        return count;
    }
    void DFS(boolean[][] visited, char[][] grid, int i, int j, int n, int m){
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        
        while(!queue.isEmpty()){
            int x = queue.peek().i;
            int y = queue.poll().j;
            
            if(x>0 && grid[x-1][y] == '1' && !visited[x-1][y]){
                visited[x-1][y] = true;
                queue.offer(new Pair(x-1, y));
            }
            if(y>0 && grid[x][y-1] == '1' && !visited[x][y-1]){
                visited[x][y-1] = true;
                queue.offer(new Pair(x, y-1));
            }
            if(x+1<n && grid[x+1][y] == '1' && !visited[x+1][y]){
                visited[x+1][y] = true;
                queue.offer(new Pair(x+1, y));
            }
            if(y+1<m && grid[x][y+1] == '1' && !visited[x][y+1]){
                visited[x][y+1] = true;
                queue.offer(new Pair(x, y+1));
            }
        }
    }
}