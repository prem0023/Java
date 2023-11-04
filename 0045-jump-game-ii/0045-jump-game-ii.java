class Solution {
    public int jump(int[] nums) {
        int jump=1, currReach=nums[0], maxReach=nums[0], curr=0;
        
        if(nums.length == 1)
            return 0;
        
        while(curr <= currReach){
            maxReach = Math.max(maxReach, curr+nums[curr]);
            
            if(currReach >= nums.length-1)
                return jump;
            
            if(curr == currReach){
                jump++;
                currReach = maxReach;
            }
            
            curr++;
        }
        return jump;
    }
}