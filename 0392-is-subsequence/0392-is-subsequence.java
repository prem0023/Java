class Solution {
    public boolean isSubsequence(String A, String B) {
        
        int n = A.length();
        int m = B.length();
        
        while(n>0 && m>0){
            if(A.charAt(n-1) == B.charAt(m-1)){
                n--; 
                m--;
            }
            else
                m--;
        }
        if(n == 0)
            return true;
        return false;
    }
    
    
}