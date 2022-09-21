// Maximum number of 2X2 squares

class Solution
{
    public static long numberOfSquares(long base)
    {
        //code here
        return (((base/2)-1)*(((base/2)-1)+1))/2;
    }
}