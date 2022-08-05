//Longest Common Subsequence using Top Down

class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int[][] t = new int[x+1][y+1];
        
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
       
        return t[x][y];
        
    }
	public static void main(String[] args) {
		
		String s1 = "asdfghwtyughjqwertyuiopzxcvbnm,asdfghjklasdfghjklzxcvbnlkjwertuyihgvbhgfcvbnjkledkopdhju";
		String s2 = "qwertgdfhqwertyuioasdfghjklzxcvbnmjbkp09o87rytfghujjkhgyukoglhlnib";
	    
		System.out.println(lcs(s1.length(), s2.length(), s1, s2));
		
	}
}