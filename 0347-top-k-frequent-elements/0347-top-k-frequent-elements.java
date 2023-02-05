class Pair
{
    int num, freq;
    Pair(int _num, int _freq){
        this.num = _num;
        this.freq = _freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        int[] ans = new int[k];
        
        for(int i=0; i<n; i++){
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
        }
        
        int c = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            c++;
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            
            if(c > k){
                c--;
                pq.poll();
            }
        }
        c = 0;
        while(!pq.isEmpty())
            ans[c++] = pq.poll().num;
        
        return ans;
        
    }
}