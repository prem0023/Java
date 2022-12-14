class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int c0, int c1) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != c0) return;
        image[i][j] = c1;
        dfs(image, i, j - 1, c0, c1);
        dfs(image, i, j + 1, c0, c1);
        dfs(image, i - 1, j, c0, c1);
        dfs(image, i + 1, j, c0, c1);
    }
}

/*
class Pair{
    int i, j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        Queue<Pair> queue = new LinkedList<>();
        int strColor = image[sr][sc];
        image[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new Pair(sr,sc));
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()){
            int x = queue.peek().i;
            int y = queue.poll().j;
            
            if(x>0 && image[x-1][y] == strColor && !visited[x-1][y]){
                image[x-1][y] = color;
                visited[x-1][y] = true;
                queue.offer(new Pair(x-1, y));
            }
            if(y>0 && image[x][y-1] == strColor && !visited[x][y-1]){
                image[x][y-1] = color;
                visited[x][y-1] = true;
                queue.offer(new Pair(x, y-1));
            }
            if(x+1<n && image[x+1][y] == strColor && !visited[x+1][y]){
                image[x+1][y] = color;
                visited[x+1][y] = true;
                queue.offer(new Pair(x+1, y));
            }
            if(y+1<m && image[x][y+1] == strColor && !visited[x][y+1]){
                image[x][y+1] = color;
                visited[x][y+1] = true;
                queue.offer(new Pair(x, y+1));
            }
        }
        return image;
    }
}
*/