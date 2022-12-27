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
    int v,w;
    Pair(int w,int v)
    {
        this.v=v;
        this.w=w;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.w-y.w);
        
        int dist[]=new int[n+1];
        int parent[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
            parent[i]=i;
        }
        dist[1]=0;
        //dist,node
        pq.add(new Pair(0,1));
        while(pq.size()>0)
        {
            Pair Node=pq.peek();
            int node=Node.v;
            int dis=Node.w;
            pq.remove();
            for(Pair it: adj.get(node))
            {
                if(dist[node]+it.w<dist[it.v])
                {
                    dist[it.v]=dist[node]+it.w;
                    parent[it.v]=node;
                    pq.add(new Pair(dis+it.w,it.v));
                }
            }
        }
        List<Integer>li=new ArrayList<>();
        if(dist[n]==Integer.MAX_VALUE)
        {
            li.add(-1);
            return li;
        }
        List<Integer> ans=new ArrayList<>();
        int node=n;
        while(parent[node]!=node)
        {
            ans.add(node);
            node=parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}