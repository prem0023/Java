// Max Min

class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        //code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i : A){
            if(i < min)
                min = i;
            if(i > max)
                max = i;
        }
        
        return min + max;
    }
}