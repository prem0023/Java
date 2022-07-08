// Median in a row-wise sorted Matrix

class Solution {
    int median(int matrix[][], int n, int m) {
        int[] a = new int[m*n];
        int k=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[k++] = matrix[i][j];
            }
        }
        Arrays.sort(a);
        return a[n*m/2];
    }
}

