// Minimum number of Partitioning to make each part Palindrome

class Solution{
    static int[][] t;
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        t = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++)
                t[i][j] = -1;
        }
        
        return getPartition(str, 0, n-1);
    }
    
    static int getPartition(String s, int i, int j){
        
        if(i>=j)
            return 0;
            
        if(t[i][j] != -1)
            return t[i][j];
            
        int cost = 0;
		
		//int cost = Integer.MAX_VALUE;
		//check if string is palindrome
		//if(checkPalindrome(s.substring(i,j+1)))
		//	return 0;
            
		
		//check if string is palindrome 
        for(int k=i; k<=j; k++){ 		
            if(s.charAt(k) != s.charAt(j-k+i)){
                cost = Integer.MAX_VALUE;
                break;
            }
        }
        if(cost == 0)
            return 0;
        
        for(int k=i; k<j; k++){
            
            int temp = 0;
            
            if(t[i][k] != -1)
                temp = t[i][k];
            else
                temp = getPartition(s, i, k);
                
            if(t[k+1][j] != -1)
                temp = temp + t[k+1][j];
            else
                temp = temp + getPartition(s, k+1, j);
              
             temp++;  
             
            //int temp = getPartition(s, i, k) + getPartition(s, k+1, j) + 1;
            
            if(temp < cost)
                cost = temp;
        }
        
        t[i][j] = cost;
        return cost;
    }
/*	
	static boolean checkPalindrome(String s){
		int n = s.length();
		for(int i=0;i<n/2;i++){
			if(s.charAt(i) != s.charAt(n-i-1))
				return false;
		}
		return true;
	}
 */
	public static void main(String[] args) {
		
		System.out.println(palindromicPartition("ababbbabbababa"));

	}
}