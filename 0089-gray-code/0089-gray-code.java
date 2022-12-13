class Solution 
{
	public List<Integer> grayCode(int n) 
	{
		// 0: [0]
		// 1: [0,1]
		// 2: [0,1,3,2]
		// 3: [0,1,3,2,6,7,5,4]
		// 4: [0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8]

		int edge = 1 << n; // (1 << n) == 2 ** n
		Integer[] ans = new Integer[edge];
		ans[0] = 0;
		int lngth = 1; // is the length of the previous block
		int i, j = 1;

		while (j != edge)
		{
			lngth = j;

			for(i = lngth - 1; i >= 0; i--)
				ans[j++] = ans[i] | lngth; // ans[i] | lngth  == ans[i] + lngth 
		}

		return Arrays.asList(ans);
	}
}