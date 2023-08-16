class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
			return new int[0];
		}
        int[] rt = new int[nums.length-k+1];
        int index = 0;
        int indexLeft = 0;
        int indexRight = k-1;
        int indexMax = findIMax(nums, indexLeft, indexLeft + k);
        rt[index++] = nums[indexMax];
        indexLeft ++;
        indexRight ++;
        
        while(indexRight < nums.length){
            if(nums[indexRight] >= nums[indexMax]){
                indexMax = indexRight;
            } else if(indexLeft > indexMax){
                // trouble. max is not in range
                if (nums[indexRight] >= nums[indexMax]-1) {
                    // if right is one less than maximum
                    indexMax = indexRight;
                }else if (nums[indexLeft] >= nums[indexMax]-1) {
                    // if left is one less than maximum
                    indexMax = indexLeft;
                }else{
                    indexMax = findIMax(nums, indexLeft, indexRight+1);
                }
            }
            rt[index++] = nums[indexMax];
            indexLeft++;
            indexRight++;
        }
       
        
        return rt;
    }
    private static int findIMax(int[] nums, int start, int end) {
        int rt = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] >= nums[rt]) {// biggest and rightmost
                rt = i;
            }
        }
        return rt;
    }
}