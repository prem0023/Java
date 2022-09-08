// Max Area Rectangle in binary matrix

//Method 1 
class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int max = 0;
        int arr[][] = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }
        
        max = largestRectangleArea(arr[0]);
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] >= 1 && arr[i-1][j] >= 1)
                    arr[i][j] = arr[i][j] + arr[i-1][j];
            }
            max = Math.max(max, largestRectangleArea(arr[i]));
        }

        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        int[] value = new int[heights.length];
        int[] indexs = new int[heights.length];

        int index = -1;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (index == -1 || value[index] < heights[i]) {
                index++;
                value[index] = heights[i];
                indexs[index] = i;
            } 
            else if (value[index] > heights[i]) {
                while (index >= 0 && value[index] >= heights[i]) {
                    max = Math.max(max, value[index] * (i - indexs[index]));
                    index--;
                }
                index++;
                value[index] = heights[i];
            }
        }

        while (index >= 0) {
            max = Math.max(max, value[index] * (heights.length - indexs[index]));
            index--;
        }

        return max; 
    }
}