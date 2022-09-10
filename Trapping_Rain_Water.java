// Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
		int max = 0;

		for (int i = 1; i < n; i++) {
			if (height[i] < height[i - 1]) {
				int j = i;
				int temp = 0;
				while (j < n && height[j] < height[i - 1]) {
					temp = temp + height[i - 1] - height[j];
					j++;
				}

				if (j == n) {
					j--;
					temp = 0;
					int x = 0;
					while (j > 0 && height[j] <= height[j - 1])
						j--;
					x = height[j];
					while (j >= i) {
						if (height[j] > x)
							x = height[j];

						temp = temp + x - height[j];
						j--;
					}
					return max + temp;
				}
				max = max + temp;
				i = j-1;
			}
		}
		return max;
	}
}