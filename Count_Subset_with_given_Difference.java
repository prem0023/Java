//Count Subset with given Difference

class Solution
{
	static int countSubsetDiff(int[] wt, int n, int diff){
		
		if(n <2)
			return 0;
		
		int sum = 0;
		int mod = 1000000007;
		
		for(int i=0;i<n;i++)
			sum = sum + wt[i];
		
		int w = (sum-diff)/2;
		
		int[][] t = new int[n+1][w+1];
		
		for(int i = 0;i<=n;i++){
			for(int j=0;j<=w;j++){
				if(j == 0)
					t[i][j] = 1;
				else
					break;
			}
		}
		
		for(int i = 1;i<=n;i++){
			for(int j=1;j<=w;j++){
				
				int p1 = t[i-1][j] % mod;
				
				if(wt[i-1] <= j)
					p1 = (p1 + t[i-1][j-wt[i-1]]) % mod;
				
				t[i][j] = p1;
			}
		}
		return t[n][w];
		
	}
	
	
	public static void main(String[] args){
		int[] wt = {1,2,3,1,2};
		int diff = 1;
		
		System.out.println(countSubsetDiff(wt,wt.length,diff));
	}
}