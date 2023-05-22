class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Creating a Frequency Table
        Map<Integer,Integer> map = new HashMap();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        // Putting values in priority queue 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        // putting the top k values in array
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = pq.poll();
        }
        return res;
    }
}