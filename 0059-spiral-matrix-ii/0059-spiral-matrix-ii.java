class Solution {
    public int[][] generateMatrix(int n) {
        int [][] a = new int[n][n];
        int l=0,t=0,b=n-1,r=n-1,v=1;
        while(t<=b||l<=r){
         if(t<=b){
             for(int i=l;i<=r;i++)
                a[t][i]=v++;
             t++;
         }
         if(l<=r){
             for(int i=t;i<=b;i++)
                 a[i][r]=v++;
             r--;
         }
         if(t<=b){
             for(int i=r;i>=l;i--)
             a[b][i]=v++;
             b--;
         }
         if(t<=b){
             for(int i=b;i>=t;i--)
             a[i][l]=v++;
         }
         l++;
        }
        return a;
    }
}