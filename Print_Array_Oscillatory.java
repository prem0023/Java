// Print Array Oscillatory

public class Solution {
	
	// Driver Method
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5}; // 1 2 3 4 5  4 3 2 3
		int r = arr.length;
		int l = 0;
		int i=0;
		int k = 1;
		while(i<r && i>=l && l<r) {
			System.out.println(arr[i]);
			i=i+k;
			if(i == r) {
				k = -1;
				i = i+2*k;
				l++;
			}
			else if(i == l) {
				k = 1;
				r--;
				r--;
			}
			
		}
	}
}