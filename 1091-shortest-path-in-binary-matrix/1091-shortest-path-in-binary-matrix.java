class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) {
            return -1;
        }
        return bfs(grid,0,0);
    }
    private int bfs(int[][] grid,int i,int j) {
		Deque<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[grid.length][grid.length];
		visited[i][j]=true;
		queue.add(new int[]{i,j});
        int n = grid.length;
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int level=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
            level++;
            while(size-->0) {
                int[] curr = queue.poll();
	    		if(curr[0]==n-1 && curr[1]==n-1) {
                    return level;
                }
                for(int[] dir:dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] +curr[1];
                    if(x<0||y<0||x>=n||y>=n||grid[x][y]==1||visited[x][y]) {
                        continue;
                    }
                    visited[x][y]=true;
                    queue.add(new int[]{x,y});
                }

            }
            
		}
		return -1;
	}
}