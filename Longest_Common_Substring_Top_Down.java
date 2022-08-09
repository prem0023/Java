//Longest Common Substring using Top Down

class Solution {

    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        
        int[][] t = new int[n+1][m+1];
        
        int max = 0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = 0;
                    
                if(t[i][j] > max)
                    max = t[i][j];
            }
        }
       
        return max;
    }
	
	public static void main(String[] args) {
		
		String s1 = "ASDFGH";
		String s2 = "ASDFQWE";
	    
		System.out.println(longestCommonSubstr(s1, s2, s1.length(), s2.length()));
		
	}
}