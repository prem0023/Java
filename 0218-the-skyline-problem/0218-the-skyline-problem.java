class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
     List<List<Integer>> resp = new ArrayList<>();
     List<int[]> heights = new ArrayList<>();

     transformBuilding(buildings, heights); 
     Collections.sort(heights, (a,b) -> (a[0]==b[0]) ? a[1] -b[1] : a[0] -b[0]); 

     PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a));
     pq.offer(0);
     int prevMax = 0;
     for(int[] height : heights){
        if(height[1]<0){
            pq.offer(-height[1]);
        } else{
            pq.remove(height[1]); 
        }
        int currentMax = pq.peek();
        if(currentMax != prevMax){
            List<Integer> subRes = new ArrayList<>();
            subRes.add(height[0]);
            subRes.add(currentMax);
            resp.add(subRes);
            prevMax = currentMax;
        }
    }
    return resp;
    }
    
    
 private void transformBuilding(int[][]buildings, List<int[]>heights) {

        for(int[] building : buildings){
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
    }
}