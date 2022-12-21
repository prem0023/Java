// Method - 1
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws IOException {
    int n = 6, m = 7;
    int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
    Solution obj = new Solution();
    int res[] = obj.shortestPath(n, m, edge);
    for (int i = 0; i < n; i++) {
      System.out.print(res[i] + " ");
    }
    System.out.println();
  }
}

class Pair {
  int first, second;
  Pair(int _first, int _second) {
    this.first = _first;
    this.second = _second;
  }
}
//User function Template for Java
class Solution {
  private void topoSort(int node, ArrayList < ArrayList < Pair >> adj,
    int vis[], Stack < Integer > st) {
    //This is the function to implement Topological sort. 

    vis[node] = 1;
    for (int i = 0; i < adj.get(node).size(); i++) {
      int v = adj.get(node).get(i).first;
      if (vis[v] == 0) {
        topoSort(v, adj, vis, st);
      }
    }
    st.add(node);
  }
  public int[] shortestPath(int N, int M, int[][] edges) {
    ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
    for (int i = 0; i < N; i++) {
      ArrayList < Pair > temp = new ArrayList < Pair > ();
      adj.add(temp);
    }
    //We create a graph first in the form of an adjacency list.

    for (int i = 0; i < M; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      adj.get(u).add(new Pair(v, wt));
    }
    int vis[] = new int[N];
    //Now, we perform topo sort using DFS technique 
    //and store the result in the stack st.

    Stack < Integer > st = new Stack < > ();
    for (int i = 0; i < N; i++) {
      if (vis[i] == 0) {
        topoSort(i, adj, vis, st);
      }
    }
    //Further, we declare a vector ‘dist’ in which we update the value of the nodes’
    //distance from the source vertex after relaxation of a particular node.
    int dist[] = new int[N];
    for (int i = 0; i < N; i++) {
      dist[i] = (int)(1e9);
    }

    dist[0] = 0;
    while (!st.isEmpty()) {
      int node = st.peek();
      st.pop();

      for (int i = 0; i < adj.get(node).size(); i++) {
        int v = adj.get(node).get(i).first;
        int wt = adj.get(node).get(i).second;

        if (dist[node] + wt < dist[v]) {
          dist[v] = wt + dist[node];
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (dist[i] == 1e9) dist[i] = -1;
    }
    return dist;
  }
}


/*
//Method - 2
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int[] ans = new int[N];
		
		for(int i=1; i<N; i++){
		    ans[i] = -1;
		}
		
		for(int i=1; i<N; i++){
		    boolean[] visited = new boolean[N];
		    DFS(edges, ans, visited, 0, i, M, N, 0);
		}
		
		return ans;
	}
	
	private void DFS(int[][] edges, int[] ans, boolean[] visited, int src, int dest, int M, int N, int wt){
	    
	    visited[src] = true;
	    if(ans[dest] != -1 && wt > ans[dest])
	        return;
	    
	    for(int i=0; i<M; i++){
	        if(edges[i][0] == src && edges[i][1] == dest){
	            if(ans[dest] == -1)
	                ans[dest] = wt + edges[i][2];
	            else
	                ans[dest] = Math.min(ans[dest], wt + edges[i][2]);
	            return;
	        }
	        if(edges[i][0] == src){
	            DFS(edges, ans, visited, edges[i][1], dest, M, N, wt+edges[i][2]);
	        }
	    }
	}
}
*/
