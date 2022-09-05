// Leap Year

class Solution{
    static int isLeap(int n){
        //code here
        
        if(n%400 == 0 || (n%4 == 0 && n%100 != 0))
            return 1;
            
        return 0;
    }
}