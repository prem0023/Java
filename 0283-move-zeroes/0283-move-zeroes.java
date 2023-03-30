class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}

/*
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i] == 0)
                zeroCount++;
            else if(zeroCount > 0){
                nums[i-zeroCount] = nums[i];
                nums[i] = 0;
            }
        }
    }
}

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
*/