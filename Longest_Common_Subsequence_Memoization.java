//Longest Common Subsequence using Memoization

class Solution
{
    static int[][] t = new int[1001][1001];
    
    static int LCS(int x, int y, String s1, String s2)
    {
        if(x == 0 || y == 0)
            return 0;
            
        if(t[x][y] != -1)
            return t[x][y];
            
        if(s1.charAt(x-1) == s2.charAt(y-1))
            t[x][y] = 1 + LCS(x-1, y-1, s1, s2);
            
        else{
            t[x][y] = Math.max(LCS(x-1, y, s1, s2), LCS(x, y-1, s1, s2));
        }
        
        return t[x][y];
    }
    
	public static void main(String[] args) {
		
		String s1 = "asdfghwtyughjqwertyuiopzxcvbnm,asdfghjklasdfghjklzxcvbnlkjwertuyihgvbhgfcvbnjkledkopdhju";
		String s2 = "qwertgdfhqwertyuioasdfghjklzxcvbnmjbkp09o87rytfghujjkhgyukoglhlnib";
	    
		for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++)
                t[i][j] = -1;
        }
		
		System.out.println(LCS(s1.length(), s2.length(), s1, s2));
		
	}
}