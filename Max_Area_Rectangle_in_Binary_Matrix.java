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

/*
// Method 2 DP approach

class Solution {
	int max = 0;

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;

		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];

		int maxA = 0;
        
        for (int i = 0; i < n; i++){
            right[i] = n;
        } 

		for (int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;
			for (int j = 0; j < n; j++) { // compute height (can do this from either side)
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			for (int j = 0; j < n; j++) { // compute left (from left to right)
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], cur_left);
				else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			// compute right (from right to left)
			for (int j = n - 1; j >= 0; j--) {
                //right[j] = n;
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], cur_right);
				else {
					right[j] = n;
					cur_right = j;
				}
			}
			// compute the area of rectangle (can do this from either side)
			for (int j = 0; j < n; j++)
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
		}
		return maxA;
	}
}

*/
