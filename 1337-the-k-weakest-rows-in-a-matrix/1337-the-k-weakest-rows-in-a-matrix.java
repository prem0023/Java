class Pair{
    int index, count;
    
    Pair(int _index, int _count){
        index = _index;
        count = _count;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.count == b.count)
                return b.index - a.index;
            
            return b.count - a.count;
            });
        
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1)
                    count++;
                else
                    break;
            }
            
            pq.offer(new Pair(i, count));
            
            if(pq.size() > k)
                pq.poll();
        }
        
        while(!pq.isEmpty()){
            ans[--k] = pq.poll().index;
        }
        
        return ans;
    }
}