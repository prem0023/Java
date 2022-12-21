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
        int[] outdegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topo = new ArrayList<>(V);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<V; i++){
            outdegree[i] = outdegree[i] + adj.get(i).size();
            for(int x : adj.get(i)){
                if(map.containsKey(x))
                    map.get(x).add(i);
                else{
                    ArrayList<Integer> templist = new ArrayList<>();
                    templist.add(i);
                    map.put(x, templist);
                }
            }
        }
        
        for(int i=0; i<V; i++){
            if(outdegree[i] == 0)
                queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int i = queue.poll();
            topo.add(i);
            if(map.containsKey(i)){
                for(int x : map.get(i)){
                    outdegree[x]--;
                    if(outdegree[x] == 0)
                        queue.offer(x);
                }
            }
        }
        
        Collections.sort(topo);
        return topo;
    }
}
