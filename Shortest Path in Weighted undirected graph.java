//My approach
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

/*
//Striver's implementation
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
*/
