//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        
        dfs(adj, vis, set, 0, -1, tin, low, 0);
        
        if(set.isEmpty()){
            ans.add(-1);
            return ans;
        }
        ans.addAll(set);
        Collections.sort(ans);
        return ans;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, 
    HashSet<Integer> set,int i, int parent, int[] tin, int[] low, int timer){
        tin[i] = low[i] = timer;
        timer++;
        vis[i] = true;
        int child = 0;
        
        for(int x : adj.get(i)){
            if(x == parent)
                continue;
            if(!vis[x]){
                dfs(adj, vis, set, x, i, tin, low, timer);
                low[i] = Math.min(low[i], low[x]);
                if(low[x] >= tin[i] && parent != -1)
                    set.add(i);
                child++;
            }
            else
                low[i] = Math.min(low[i], low[x]);
        }
        if(parent == -1 && child > 1)
            set.add(i);
    }
}