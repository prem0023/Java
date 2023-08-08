class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = -1;
        int l=0, r=n-1;
        
        if(target < matrix[0][0] || target > matrix[n-1][m-1])
            return false;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target){
                row = mid;
                break;
            }
            else if(matrix[mid][0] > target){
                r = mid-1;
            }
            else
                l = mid+1;
        }
        
        l=0;
        r=m-1;
        
        if(row == -1)
            return false;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] > target){
                r = mid-1;
            }
            else
                l = mid+1;
        }
        
        return false;
    }
}