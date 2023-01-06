class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(List<Integer> l : connections){
            adj.get(l.get(0)).add(l.get(1));
            adj.get(l.get(1)).add(l.get(0));
        }
        
        tin[0] = -1;
        dfs(adj, vis, ans, tin, low, 0, 0, -1);
        
        return ans;
    }
    
    void dfs(List<List<Integer>> adj, boolean[] vis, List<List<Integer>> ans, int[] tin, int[] low, int i, int timer, int parent){
        
        vis[i] = true;
        tin[i] = low[i] = timer;
        timer++;
        
        for(int x : adj.get(i)){
            if(x == parent)
                continue;
            if(!vis[x]){
                dfs(adj, vis, ans, tin, low, x, timer, i);
                low[i] = Math.min(low[i], low[x]);
                
                if(low[x] > tin[i])
                    ans.add(Arrays.asList(i, x));
            }
            else
                low[i] = Math.min(low[i], low[x]);
        }
    }
}
