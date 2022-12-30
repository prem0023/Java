
class Solution {

        static int countPaths(int n, int[][] roads) {
        // Your code here
            final int mod = 1_000_000_007;
        int[][] adj = new int[n][n];
        //adjacency list creation
        for(int[] road : roads){
            adj[road[0]][road[1]] = road[2];
            adj[road[1]][road[0]] = road[2];
        }
        //creating and filling ways and cost array
        //it can be also said to be type of tabulation (dp) problem because we have to memorize the ways we reach to node
        long[] cost = new long[n], ways = new long[n];
        Arrays.fill(cost,1,n, Long.MAX_VALUE);
        ways[0]=1;

        Queue<long[]> q = new PriorityQueue<>((a, b)->Long.compare(a[1], b[1]));
        q.offer(new long[]{0,0});

        while(!q.isEmpty()){
            long[] e = q.poll();
            int v = (int) e[0];
            long t = e[1];
            if(t <= cost[v]){
                for(int i=0;i<n;i++){
                    if(adj[v][i]!=0){
                        //here if we get a cheaper path to operate then we go through every path that is to adj[v][i] node
                        if(cost[v]+adj[v][i] < cost[i]){
                            cost[i] = cost[v]+adj[v][i];

                            q.offer(new long[]{i,cost[i]});
                            ways[i] = ways[v];
                            
                        }else if(cost[v]+adj[v][i] == cost[i]){//if cost is same then we will update the ways with which we 
                            //reach to parent node +current node
                            ways[i] = (ways[i]+ways[v]) % mod;
                        }
                    }
                }
            }
        }
        return (int) ways[n-1];
    }
}
