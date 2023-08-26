class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        
        int count = 1;
        
        int min = pairs[0][1];
        
        for(int i=1;i<pairs.length;i++){
            if(min<pairs[i][0]) {
                count++;
                min = pairs[i][1];
            }
        }
        	
		return count;
	}

	

}