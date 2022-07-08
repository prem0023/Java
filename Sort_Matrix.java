// Sort Matrix

class Solution {
    int[][] sortedMatrix(int N, int Mat[][]) {
        int[] a = new int[N*N];
        int k=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                a[k++] = Mat[i][j];
            }
        }
        Arrays.sort(a);
        k=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Mat[i][j] =a[k++];
            }
        }
        return Mat;
    }
    
}