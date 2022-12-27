class Pair
{
    int dist;
    int[] src;
    Pair(int dist, int[] src){
        this.dist = dist;
        this.src = src;
    }
}

// User function Template for Java

class Solution {

    static int shortestPath(int[][] grid, int[] src, int[] dest) {

        // Your code here
        if(src[0] == dest[0] && src[1] == dest[1])
            return 0;
        
        Queue<Pair> pq = new LinkedList<>();
        int n = grid.length;
        int m =  grid[0].length;
        int[][] ans = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[src[0]][src[1]] = 0;
        pq.add(new Pair(0, src));
        
        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int i = pq.peek().src[0];
            int j = pq.poll().src[1];
            int[] temp;
            
            if(i == dest[0] && j == dest[1])
                return ans[i][j];
            
            if(i>0 && grid[i-1][j] == 1 && ans[i-1][j] > dist+1){
                ans[i-1][j] = dist+1;
                temp = new int[2];
                temp[0] = i-1;
                temp[1] = j;
                pq.offer(new Pair(ans[i-1][j], temp));
            }
            if(i+1<n && grid[i+1][j] == 1 && ans[i+1][j] > dist+1){
                ans[i+1][j] = dist+1;
                temp = new int[2];
                temp[0] = i+1;
                temp[1] = j;
                pq.offer(new Pair(ans[i+1][j], temp));
            }
            if(j>0 && grid[i][j-1] == 1 && ans[i][j-1] > dist+1){
                ans[i][j-1] = dist+1;
                temp = new int[2];
                temp[0] = i;
                temp[1] = j-1;
                pq.offer(new Pair(ans[i][j-1], temp));
            }
            if(j+1<m && grid[i][j+1] == 1 && ans[i][j+1] > dist+1){
                ans[i][j+1] = dist+1;
                temp = new int[2];
                temp[0] = i;
                temp[1] = j+1;
                pq.offer(new Pair(ans[i][j+1], temp));
            }
        }
        return -1;
    }
}
