//kthGrammar

class Solution {
    public static int kthGrammar(int n, int k) {
        
        if(n==1 && k == 1)
            return 0;
        
        int i = (int)Math.pow(2,n-1);
        i = i/2;
        
        if(i>=k)
            i = kthGrammar(n-1,k);
        else {
            i = kthGrammar(n-1, k-i);
            if(i==0)
                i = 1;
            else
                i = 0;
        }
        
        return i;
    }
		
	
	public static void main(String[] args) {
		
		//System.out.println("123".substring(0,1));
		int x = kthGrammar(2,2);
		
		System.out.println(x);
	}
}