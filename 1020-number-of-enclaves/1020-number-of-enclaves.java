class Solution {
    public int numEnclaves(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(a[i][j] == 1 && !visited[i][j]){
                        DFS(a, visited, i, j, n, m);
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && a[i][j] == 1)
                    ans++;
            }
        }
        
        return ans;
    }
    static void DFS(int a[][], boolean[][] visited, int x, int y, int n, int m) {
		visited[x][y] = true;
		
		if (x > 0 && a[x - 1][y] == 1 && !visited[x - 1][y])
			DFS(a, visited, x - 1, y, n, m);
			
		if (x + 1 < n && a[x + 1][y] == 1 && !visited[x + 1][y])
			DFS(a, visited, x + 1, y, n, m);
			
		if (y > 0 && a[x][y - 1] == 1 && !visited[x][y - 1])
			DFS(a, visited, x, y - 1, n, m);
			
		if (y + 1 < m && a[x][y + 1] == 1 && !visited[x][y + 1])
			DFS(a, visited, x, y + 1, n, m);
			
	}
}