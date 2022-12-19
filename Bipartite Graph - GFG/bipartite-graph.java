//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends

class Pair{
    int i;
    char c;
    Pair(int i, char c){
        this.i = i;
        this.c = c;
    }
}
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        char[] col = new char[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(!BFS(adj, visited, i, col))
                    return false;
            }
        }
        return true;
    }
    boolean BFS(ArrayList<ArrayList<Integer>>adj, boolean[] visited, int i, char[] col){
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, 'R'));
        
        while(!queue.isEmpty()){
            i = queue.peek().i;
            char c;
            if(queue.poll().c == 'R')
                c = 'B';
            else
                c = 'R';
            
            for(int x : adj.get(i)){
                if(!visited[x]){
                    col[x] = c;
                    queue.offer(new Pair(x, c));
                    visited[x] = true;
                }
                else if(col[x] != c)
                    return false;
            }
        }
        return true;
    }
}