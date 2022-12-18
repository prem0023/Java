class Solution {
    public void solve(char[][] a) {
        
        int n = a.length;
        int m = a[0].length;
        boolean[][] visited = new boolean[n][m];
        char[][] ans = new char[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(a[i][j] == 'O' && !visited[i][j]){
                        DFS(a, ans, visited, i, j, n, m);
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j])
                    a[i][j] = 'X';
                else
                    a[i][j] = 'O';
            }
        }

    }
    static void DFS(char a[][], char[][] ans, boolean[][] visited, int x, int y, int n, int m) {
		visited[x][y] = true;
		
		if (x > 0 && a[x - 1][y] == 'O' && !visited[x - 1][y])
			DFS(a, ans, visited, x - 1, y, n, m);
			
		if (x + 1 < n && a[x + 1][y] == 'O' && !visited[x + 1][y])
			DFS(a, ans, visited, x + 1, y, n, m);
			
		if (y > 0 && a[x][y - 1] == 'O' && !visited[x][y - 1])
			DFS(a, ans, visited, x, y - 1, n, m);
			
		if (y + 1 < m && a[x][y + 1] == 'O' && !visited[x][y + 1])
			DFS(a, ans, visited, x, y + 1, n, m);
			
	}
}