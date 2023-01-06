//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> ad = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        
        for(int i=0; i<V; i++){
            ad.add(new ArrayList<>());
        }
        
        for(int i=0; i<adj.size(); i++){
            for(int x : adj.get(i))
                ad.get(x).add(i);
        }
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                DFS(adj, vis, i, stack);
            }
        }
        vis = new boolean[V];
        
        while(!stack.isEmpty()){
            int i = stack.pop();
            //System.out.println(i);
            if(!vis[i]){
                count++;
                dfs(ad, vis, i);
            }
        }
        return count;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> ad, boolean[] vis, int i){
        if(vis[i])
            return;
        
        vis[i] = true;
        
        for(int x : ad.get(i)){
            if(!vis[x]){
                dfs(ad, vis, x);
            }
        }
    }
    
    void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i, Stack<Integer> stack){
        if(vis[i])
            return;
        
        vis[i] = true;
        
        for(int x : adj.get(i)){
            if(!vis[x]){
                DFS(adj, vis, x, stack);
            }
        }
        stack.push(i);
    }
}
