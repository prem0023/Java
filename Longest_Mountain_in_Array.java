// Longest Mountain in Array

class Solution {
    public int longestMountain(int[] nums) {
        int res=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            //flag is used to deduct the case where whole array is increasing and not decreasing
            boolean flag=false;
            int count=1;
            int j=i;
            //increasing
            while(j<n && nums[j]>nums[j-1]){
                j++;
                count++;
            }
            //decreasing
            while(i!=j && j<n && nums[j]<nums[j-1]){
                j++;
                count++;
                flag=true;
            }
            //max length
            if(count>2 && flag){
                res=Math.max(count,res);
                j--;
            }
            i=j;
        }
        
        return res;
    }
}

/*

class Solution {
    public int longestMountain(int[] arr) {
        
        int n = arr.length;
        if(n < 3)
            return 0;
        
        int l = -1;
        int max = 0;
        int x = 0;
        
        if(arr[1] > arr[0])
        	l = 0;
        
        for(int i=1; i<n-1; i++){
        	
        	if(arr[i] < arr[i-1] && arr[i] <= arr[i+1]) {
        		if(l != -1 && x == 1) {
            		max = Math.max(max, i-l+1);
            		x = 0;
            	}
        	}
            if(arr[i] <= arr[i-1] && arr[i]<arr[i+1])
            	l = i;
            
            else if(arr[i] == arr[i-1] && arr[i] > arr[i+1])
            	l = -1; 
            
            else if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
            	x = 1;
        }
        
        if(arr[n-1]<arr[n-2] && l != -1){
            if(max < n-1-l+1)
                max = n-1-l+1; 
        }
        return max;
    }
}

*/