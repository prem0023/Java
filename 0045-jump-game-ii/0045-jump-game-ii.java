class Solution {
    public int jump(int[] nums) {
        int jump=0, currReach=0, maxReach=0, curr=0;
        
        if(nums.length == 1)
            return 0;
        
        while(curr < nums.length-1){
            maxReach = Math.max(maxReach, curr+nums[curr]);
            
            if(curr == currReach){
                jump++;
                currReach = maxReach;
            }
            
            curr++;
        }
        return jump;
    }
}