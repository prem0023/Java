class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0; i<n; i++)
            pq.offer(stones[i]);
        
        while(!pq.isEmpty()){
            int y = pq.poll();

            if(pq.isEmpty())
                return y;

            int x = pq.poll();
            if(x == y)
                continue;

            pq.offer(y-x);
        }
        
        return 0;
    }
}