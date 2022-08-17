// Find Missing Number in an Array


class Solution {
    // If arr has positive integer
	static int findMissingNumber(int[] arr) {
		
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			if(arr[i] <= n && arr[i] > 0)
				arr[arr[i]-1] = -1 * arr[arr[i]-1];
			
			else if(arr[i] < 0) {
				int temp = -1 * arr[i];
				arr[temp-1] = -1 * arr[temp-1];
			}
		}
		
		for(int i=0; i<n; i++) {
			if(arr[i] > 0)
				return i+1;
		}
		return n+1;
	}
	
	// If array has both positive and negative integer
	static int findMissingNumber2(int[] arr) {
		
		int n = arr.length;
		
		int i = 0;
		
		while(i<n) {
			if(arr[i] == i+1 || arr[i]<=0 || arr[i]>n)
				i++;
			else {
				int temp = arr[i];
				arr[i] = arr[arr[i]-1];
				arr[temp-1] = temp;
			}
	
		}
		
		for(i=0; i<n; i++) {
			if(arr[i] >= 0 && arr[i] != i+1)
				break;
		}
		return i+1;
	}


	public static void main(String[] args) {
		int[] a = {1,6,5,2,3,4,9,8,7}; //7
		
		System.out.println(findMissingNumber(a));
	}
}