class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
            j++;
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