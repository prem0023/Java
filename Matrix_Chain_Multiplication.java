// Matrix Chain Multiplication

class Solution{
    static int[][] t;
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        t = new int[N+1][N+1];
        
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++)
                t[i][j] = -1;
        }
        
        return getMinCost(arr, 1, N-1);
    }
    
    static int getMinCost(int[] arr, int i, int j){
        
        if(i >= j)
            return 0;
            
        if(t[i][j] != -1)
            return t[i][j];
        
        int cost = Integer.MAX_VALUE;
        
        for(int k=i; k<j; k++){
            
            int temp = getMinCost(arr, i, k) + getMinCost(arr, k+1, j);
            
            temp = arr[i-1]*arr[k]*arr[j] + temp;
            
            if(temp < cost)
                cost = temp;
        }
        t[i][j] = cost;
        
        return cost;
    }
	
	public static void main(String[] args) {
		int[] a = {40, 20, 30, 10, 30};
		
		System.out.println(matrixMultiplication(a.length, a));
	}
}