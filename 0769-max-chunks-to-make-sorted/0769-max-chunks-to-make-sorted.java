class Solution {
    public int maxChunksToSorted(int[] arr) {
        //1 2 0 3
        //0 1 2 3
        int n = arr.length;
        int count = 0;
        int maxNum = arr[0];
        int i = 0;
        
        while(i <= maxNum && i < n){
            maxNum = Math.max(maxNum, arr[i]);
            if(i == maxNum){
                count++;
                if(i+1 < n){
                    maxNum = arr[i+1];
                }
            }
            i++;
        }
        return count;
    }
}

// we will check if max element of a chunk will visited when I am at index of the max num then I can say I have all the element of that range present in that chunks.
// so I will iterate the array and check if maxNum == i, if yes then increase the count of chunk, also I will check if we got greater number than the max if yes then change the max num