class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        for(int i=0; i<n-1; i++){
            arr1[i] = nums[i];    //include first element and not include last element
            arr2[i] = nums[i+1];  //not include first element and include last element
        }
        int x = arr1.length-1;
        //1.Recursion
        // return Math.max(help(arr1,x), help(arr2,x));
        
        //2.Memoization - Top-Down DP
        // int dp[] = new int[x+1];
        // for(int i=0; i<x+1; i++)
        //     dp[i]=-1;
        // int ans1 = Memo(x,arr1,dp);
        // for(int i=0; i<x+1; i++)
        //     dp[i]=-1;
        // int ans2 = Memo(x,arr2,dp);
        // return Math.max(ans1,ans2);
        
        //3.Tabulation - Bottom-Up Dp
        return Math.max(DP(arr1), DP(arr2));
    }
    public int help(int[] nums,int index){
        if(index==0)return nums[index];
        if(index<0)return 0;
        
        int include = nums[index] + help(nums,index-2);
        int notInclude = help(nums,index-1);
        
        return Math.max(include,notInclude);
    }
    int Memo(int index,int[] nums, int dp[]){
        if(index==0)return nums[0];
        if(index<0)return 0;
        if(dp[index]!=-1)return dp[index];
           
        int include = Memo(index-2,nums,dp) + nums[index];
        int exclude= Memo(index-1,nums,dp);
        
        return dp[index]=Math.max(include,exclude);
    }
    int DP(int[] nums){
        int n = nums.length;
        int dp[] = new int[n];

        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int include = nums[i];
            if(i>1){
               include = include + dp[i-2];
            }  
            int exclude = dp[i-1];
            dp[i] = Math.max(include,exclude);
        }
        return dp[n-1];
    }
    
}