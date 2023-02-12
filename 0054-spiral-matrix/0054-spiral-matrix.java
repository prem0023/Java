class Solution {
    boolean[][] visited;
    int[] x=new int[]{0,1,0,-1};
    int[] y=new int[]{1,0,-1,0};
    int[][] matrix;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        visited=new boolean[matrix.length][matrix[0].length];
        this.matrix=matrix;
        List<Integer> result=new LinkedList<>();
        spiral(0,0,0,result);
        return result;
    }
    
    public void spiral(int i,int j,int c,List<Integer> result){
        result.add(matrix[i][j]);
        visited[i][j]=true;
          if(checkValid(i,j,c)){
            c++;
            if(c>x.length-1)
                c=0;
        }
        if(checkValid(i,j,c))
            return;
        spiral(i+x[c],j+y[c],c,result);
    }
    
    public boolean checkValid(int i,int j,int c){
        if(i+x[c]>matrix.length-1 || i+x[c]<0 || j+y[c]>matrix[0].length-1 || j+y[c]<0 || visited[i+x[c]][j+y[c]])   
            return true;
        return false;
    }
}