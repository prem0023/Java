class Solution {
    public void moveZeroes(int[] nums) {
        int indexZero = 0, indexNonZero = 1;
        int n = nums.length;
        
        // 0,1,0,3,12
        while(indexNonZero < n){
            if(nums[indexZero] == 0){
                while(indexNonZero < n && nums[indexNonZero] == 0)
                    indexNonZero++;
                
                if(indexNonZero == n)
                    return;
                
                nums[indexZero] = nums[indexNonZero];
                nums[indexNonZero] = 0;
                indexNonZero++;
            }
            indexZero++;
            indexNonZero = Math.max(indexNonZero, indexZero+1);
        }
    }
}