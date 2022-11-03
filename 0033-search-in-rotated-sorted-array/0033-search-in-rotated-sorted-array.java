class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        
        if(n == 1){
            if(target == nums[0])
                return 0;
            return -1;
        }
        if(nums[0] == target)
            return 0;
        if(nums[n-1] == target)
            return n-1;
        
        if(nums[n-1] > nums[0])
            return binarySearch(nums, 0, n-1, target);
        
        int l = 1;
        int r = n-1;
        int x = nums[0];
        int mid = 0;
        
        while(l <= r){ 
            mid = (l+r)/2;
            if(nums[mid] < nums[mid-1])
                break;
            else if(nums[mid] > x)
                l = mid+1;
            else
                r = mid-1;
            
        }
        
        if(nums[n-1] > target)
            return binarySearch(nums, mid, n-1, target);
        
        return binarySearch(nums, 0, mid-1, target);
        
    }
    
    int binarySearch(int[] nums, int l, int r, int target){
        
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                r = mid-1;
            else
                l = mid+1;
        }
        
        return -1;
    }
}