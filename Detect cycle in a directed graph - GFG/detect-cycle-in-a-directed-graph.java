//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            for(int x : adj.get(i))
                indegree[x]++;
        }
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int i = queue.poll();
            if(indegree[i] == 0){
                for(int x : adj.get(i)){
                    indegree[x]--;
                    if(indegree[x] == 0)
                        queue.offer(x);
                }
            }
        }
        for(int i=0; i<V; i++){
            if(indegree[i] > 0)
                return true;
        }
        
        return false;
    }
}