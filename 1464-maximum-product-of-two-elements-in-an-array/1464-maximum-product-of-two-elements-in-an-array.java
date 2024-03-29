class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0; i<nums.length; i++)
            pq.offer(nums[i]);
        
        return (pq.poll()-1) * (pq.poll()-1);
    }
}