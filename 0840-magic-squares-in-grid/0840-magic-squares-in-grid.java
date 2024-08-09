class Solution {
    int ans=0;
    public int numMagicSquaresInside(int[][] grid) {
        int  n=grid.length;
        int m=grid[0].length;

        if(n<3 || m<3)
         return 0;
        
        for(int i=0;i<=n-3;i++)
         for(int j=0;j<=n-3;j++)
          help(i,j,grid);
        
        return ans;
    }
    public void help(int x,int y,int mat[][])
    {
       int sum[]=new int[3];
       int sumcol[]=new int[3];
       boolean[] arr=new boolean[10];

       for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
        {
            //row sum
            sum[i]+=mat[x+i][y+j];
            //column sum
            sumcol[j]+=mat[x+i][y+j];
            
            //Must have valus between 1 to 9 and must be unique
            if(mat[x+i][y+j]>9 || mat[x+i][y+j]==0 || arr[mat[x+i][y+j]]==true)
             return;
            arr[mat[x+i][y+j]]=true;
        }
       
       //Row sum must be equal to Column sum
       for(int i=1;i<3;i++)
         if(sum[i]!=sum[i-1] || sum[i]!=sumcol[i] || sumcol[i]!=sumcol[i-1])
            return;
       
       int dig=mat[x][y]+mat[x+1][y+1]+mat[x+2][y+2];
       
       //Diagonals sum must be equal and equal to any of the row or sum
       if(dig!=(mat[x][y+2]+mat[x+1][y+1]+mat[x+2][y]) || dig!=sum[0])
        return;
       
       ans++;
    }
}