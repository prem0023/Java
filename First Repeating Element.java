// First Repeating Element

class Solution {
	// Function to return the position of the first repeating element.
	public static int firstRepeated(int[] arr, int n) {
		// Your code here
		int min = -1;
		HashSet<Integer> hs = new HashSet<>();
		
		for (int i = n - 1; i >= 0; i--) {
			if (hs.contains(arr[i]))
				min = i;
			else
				hs.add(arr[i]);
		}
		if (min != -1) {
			return min + 1;
		} else
			return -1;
	}
}