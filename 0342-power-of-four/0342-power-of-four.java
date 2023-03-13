class Solution {
    public boolean isPowerOfFour(int n) {
        double x = Math.log(n)/Math.log(4);
        int y = (int)x;
        
        if(x == y)
            return true;
        
        return false;
    }
}