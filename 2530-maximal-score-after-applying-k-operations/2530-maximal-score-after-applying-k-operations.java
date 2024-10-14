class Solution {
    public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int num : nums)
            pq.add(num);
        
        while (k-- > 0) {
            int max = pq.poll();
            res += max;
            pq.add((max + 2) / 3);
        }
        return res;
    }
}