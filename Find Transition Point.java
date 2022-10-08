// Find Transition Point

class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
        if(arr[n-1] == 0)
            return -1;
            
        if(n == 1 || arr[0] == 1)
            return 0;
        
        int l = 0, r = n;
        
        while(l<r){
            int mid =  (l+r)/2; //l + (r-l)/2;
            if(arr[mid] == 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if(arr[r] == 0)
            return r+1;
        return r;
    }
}

/*
// Method 2
class GfG {
    int transitionPoint(int arr[], int n) {
        // code here
        int key=1,res=-1;
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==key){
                res=mid;
                high=mid-1;
            }
            else if(arr[mid]<key){
                low=mid+1;
            }
        }
        return res;
    }
}
*/