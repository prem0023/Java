// Check if string is rotated by two places

class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        String s1 = str1.substring(2) + str1.substring(0,2);
        String s2 = str1.substring(str1.length()-2) + str1.substring(0,str1.length()-2);
        
        if(s1.equals(str2) || s2.equals(str2))
            return true;
            
        return false;
    }
    
}