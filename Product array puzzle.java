// Product array puzzle

class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        long[] ans = new long[n];
        
        long sum = 1;
        int c = 0;
        
        for(int i : nums){
            if(i == 0)
                c++;
            else
                sum = sum*i;
        }
        if(c == 0){
            for(int i=0; i<n; i++)
                ans[i] = sum/nums[i];
        }
        else if(c == 1){
            for(int i=0; i<n; i++){
                if(nums[i] == 0){
                    ans[i] = sum;
					break;
				}
            }
        }
        return ans;
	} 
} 
