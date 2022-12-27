//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Pair
{
    int dist;
    int node;
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        List<Integer> ans = new ArrayList<>();
        int[] len = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int i=0; i<=n; i++) {
        	len[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<m; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();
            
            temp.add(edges[i][1]);
            temp.add(edges[i][2]);
            adj.get(edges[i][0]).add(temp);
            
            temp2.add(edges[i][0]);
            temp2.add(edges[i][2]);
            adj.get(edges[i][1]).add(temp2);
        }
        
        len[1] = 0;
        pq.offer(new Pair(0, 1));
        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int node = pq.poll().node;
            
            for(ArrayList<Integer> l : adj.get(node)){
                if(len[l.get(0)] > dist + l.get(1)){
                    len[l.get(0)] = dist + l.get(1);
                    pq.offer(new Pair(len[l.get(0)], l.get(0)));
                    map.put(l.get(0), node);
                }
            }
        }
        
        if(!map.containsKey(n)) {
        	ans.add(-1);
        	return ans;
        }
        
        int node = n;
        ans.add(n);
        while(node != 1) {
        	node = map.get(node);
        	ans.add(node);
        }
        Collections.reverse(ans);
        return ans;
    }
}