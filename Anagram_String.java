// Anagram

class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        int sum1=0;
        int sum2=0;
        
        int n1=a.length();
        int n2 =b.length();
        
        if(n1!=n2) return false;
        
        for(int i=0;i<n1;i++){
            sum1 +=a.charAt(i);
            sum2 +=b.charAt(i);
        }
        
        return (sum1==sum2);
        
    }
}