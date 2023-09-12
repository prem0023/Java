class Solution {
    public int minDeletions(String s) {
        int n = s.length(), count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            int freq = map.getOrDefault(c, 0);
            map.put(c, freq+1);
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(entry.getValue());
        }
        
        while(!pq.isEmpty() && pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            // System.out.println("a: " + a + " b: " + b);
            if(a == b){
                b--;
                count++;
                pq.offer(a);
            }
            if(b > 0)
                pq.offer(b);
        }
        
        return count;
    }
}