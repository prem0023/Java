class Solution {
    private boolean isSameColored(int node,int color,int[] vis,int[][] graph){
        vis[node]=color;
        //neighbours
        for(int it:graph[node]){
            if(vis[it]==0){
                if(isSameColored(it,-color,vis,graph)==true)
                    return true;
            }
            else if(vis[it]==color)
                return true;
        }
        return false;
        
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(isSameColored(i,1,vis,graph)==true)
                    return false;
            }
        }
        return true;
    }
}