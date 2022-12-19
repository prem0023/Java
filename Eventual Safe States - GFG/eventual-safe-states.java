//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean[] path = new boolean[V];
        boolean[] visited = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(!visited[i])
                DFS(adj, path, visited, i, V);
        }
        
        for(int i=0; i<V; i++){
            if(!path[i])
                ans.add(i);
        }
        return ans;
    }
    
    boolean DFS(List<List<Integer>> adj, boolean[] path, boolean[] visited, int i, int V){
        
        visited[i] = true;
        path[i] = true;
        
        for(int x : adj.get(i)){
            if(!visited[x]){
                if(DFS(adj, path, visited, x, V))
                    path[x] = false;
                else
                    return false;
            }
            else{
                if(path[x])
                    return false;
            }
        }
        path[i] = false;
        return true;
    }
}
