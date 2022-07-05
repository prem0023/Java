// Reverse Integer using Recursion

public class Solution {
	/* Print duplicates present
	in the passed string */
	static int Reverse(int n) {
		if(n/10 == 0)
			return n;
		
		int r = n%10;
		n = n/10;
		int k = Reverse(n);
		int l = (int) (Math.log10(n) + 1);
		k = r * (int)Math.pow(10, l) + k;
		return k;
	}
	

	// Driver Method
	public static void main(String[] args)
	{
		int n = 62;
		System.out.println(Reverse(n));
	}
}