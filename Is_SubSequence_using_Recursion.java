// Is SubSequence using Recursion

class Solution{
    
    boolean isSubSequence(String A, String B){
        
        return issubSequence(A, B, A.length(), B.length());
    }
    
    boolean issubSequence(String s1, String s2, int n, int m){
        
        if(n == 0)
            return true;
        if(m == 0)
            return false;
            
        boolean p1 = false;
        
        if(s1.charAt(n-1) == s2.charAt(m-1))
            p1 = issubSequence(s1, s2, n-1, m-1);
        
        else
            p1 = issubSequence(s1, s2, n, m-1);
        
        return p1;
    }
}