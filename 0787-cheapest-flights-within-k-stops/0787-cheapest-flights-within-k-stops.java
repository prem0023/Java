class Pair
{
    int len,src,cost;
    Pair(int len, int src, int cost){
        this.len = len;
        this.src = src;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        int m = flights.length;
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            ans[i] = Integer.MAX_VALUE;
        }
        ans[src] = 0;
        for(int i=0;i<m;i++)
        {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(new Integer(flights[i][1]));
            l.add(new Integer(flights[i][2]));
            adj.get(flights[i][0]).add(l);
        }
        
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0, src, 0));
        
        while(!pq.isEmpty()){
            int len = pq.peek().len;
            int cost = pq.peek().cost;
            int sr = pq.poll().src;
            
            if(len > k)
                continue;
            
            for(List<Integer> x : adj.get(sr)){
                if(len<=k && cost+x.get(1) < ans[x.get(0)]){
                    ans[x.get(0)] = cost + x.get(1);
                    pq.offer(new Pair(len+1, x.get(0), ans[x.get(0)]));
                } 
            }
        }
        if(ans[dest] != Integer.MAX_VALUE)
            return ans[dest];
        
        return -1;
    }
}