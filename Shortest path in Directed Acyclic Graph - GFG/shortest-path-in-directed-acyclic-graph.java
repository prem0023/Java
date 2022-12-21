//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
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