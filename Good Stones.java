// link - https://practice.geeksforgeeks.org/problems/e2d156755ca4e0a9b9abf5680191d4b06e52b1a8/1

class Solution {
    public static int goodStones(int n, int[] arr) {
        // code here
        ArrayList<Integer> adj = new ArrayList<>();
        int ans = 0;
        boolean[] vis = new boolean[n];
        
        for(int i=0; i<n; i++){
            int x = i+arr[i];
            
            adj.add(x);
        }
        
        for(int i=0; i<n; i++){
            if(!vis[i])
                dfs(adj, vis, i, n);
        }
        
        for(int i=0; i<n; i++){
            if(!vis[i])
                ans++;
        }
        return ans;
    }
    
    private static boolean dfs(ArrayList<Integer> adj, boolean[] vis, int i, int n){
        vis[i] = true;
        
        if(adj.get(i) >= 0 && adj.get(i) < n && vis[adj.get(i)])
            return true;
        
        if(adj.get(i) >= 0 && adj.get(i) < n){
            if(dfs(adj, vis, adj.get(i), n))
                return true;
        }
        
        vis[i] = false;
        return false;
    }
}
        
