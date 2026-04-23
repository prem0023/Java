class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        int x=0,y=n-1, j=0; //i,j -> j,n-i
        
        while(x<=y){
            for(int i=x; i<=y; i++){
                int temp = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];

                int temp2 = matrix[n-i][n-j];
                matrix[n-i][n-j] = temp;

                temp = matrix[n-j][i];
                matrix[n-j][i] = temp2;

                matrix[i][j] = temp;
            }
            x++;
            y--;
            j++;
        } 
    }
}