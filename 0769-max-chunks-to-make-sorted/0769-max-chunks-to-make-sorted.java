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
//Intution: I will check If I am present at the index of max Visited number, if yes then we got the sub array/chunks where all elements till that range are present, hence we got one chunks.

//Code: I will iterate the array and check if we got greater number than the current max if yes then change the max num. Also check if maxNum == i, if yes then increase the count of chunk, also I will 