class Solution {
    public void nextPermutation(int[] nums) {
        // 0 1 2 3 4 5 6 7
        // 2 3 5 3 4 2 1
        // 1 1 5
        int n = nums.length;
        for(int i=n-1; i>0; i--){
            if(nums[i] <= nums[i-1]){
                continue;
            }
            int j=i,k=n-1, m=n-1;
            boolean flag = true;
            while(j<=k){
                if(nums[j]>nums[i-1] && flag){
                    m = k;
                }
                if(nums[k]>nums[i-1] && flag){
                    m = j;
                    flag = false;
                }
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                j++;
                k--;
            }
            int temp = nums[i-1];
            nums[i-1] = nums[m];
            nums[m] = temp;
            return;
        }

        int i=0,j=n-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}