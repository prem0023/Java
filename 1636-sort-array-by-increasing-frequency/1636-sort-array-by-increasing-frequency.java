class Pair
{
    int num, freq;
    Pair(int _num, int _freq){
        this.num = _num;
        this.freq = _freq;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
        	if(a.freq != b.freq)
        		return a.freq - b.freq;
        	
        	return b.num - a.num;
        });
        
        for(int i=0; i<n; i++){
            int x = map.getOrDefault(nums[i], 0);
            map.put(nums[i], x+1);
        }
  
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        
        int c = 0;
        while(!pq.isEmpty()){
            int m = pq.peek().freq;
            int x = pq.poll().num;
            for(int i=0; i<m; i++)
                ans[c++] = x;
        }
        
        return ans;
    }
}