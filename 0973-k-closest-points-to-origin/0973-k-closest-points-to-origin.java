class Tuple
{
    int x, y;
    int dist;
    Tuple(int _x, int _y, int _dist){
        this.x = _x;
        this.y = _y;
        this.dist = _dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        int n = points.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> b.dist - a.dist);
        
        int c = 0;
        for(int i=0; i<n; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            
            c++;
            pq.offer(new Tuple(x,y,dist));
            
            if(c > k)
                pq.poll();
        }
        c = 0;
        while(!pq.isEmpty()){
            ans[c][0] = pq.peek().x;
            ans[c++][1] = pq.poll().y;
        }
        
        return ans;
    }
}