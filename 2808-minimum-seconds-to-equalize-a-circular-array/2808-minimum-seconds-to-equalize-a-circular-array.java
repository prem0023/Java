class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.size();
        int minTime = n/2;
        
        for(int i=0; i<n; i++){
            ArrayList<Integer> temp = map.getOrDefault(nums.get(i), new ArrayList<>());
            temp.add(i);
            map.put(nums.get(i), temp);
        }
        
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            
            int maxDiff = (n + value.get(0) - value.get(value.size()-1))/2;
            
            
            for(int i=1; i<value.size(); i++){
                int diff = ((value.get(i) - value.get(i-1) + n)%n)/2;
                maxDiff = Math.max(maxDiff, diff);
            }
            
            minTime = Math.min(minTime, maxDiff);
        }
        
        return minTime;
    }
}