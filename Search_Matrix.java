// Search element in Matrix

class Solution {
    public static  boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int j=0;
        int i=1;
        while(i<n){
        	if(matrix[i][0] == target)
        		return true;
        	else if(matrix[i][0] > target){	
        		i--;
                j=0;
                while(j<m){
                    if(matrix[i][j] == target)
                        return true;
                    j++;
                }
                return false;
            }
            i++;
        }
        i--;
        while(j<m){
            if(matrix[i][j] == target)
                return true;
            j++;
        }
        return false;
    }
}