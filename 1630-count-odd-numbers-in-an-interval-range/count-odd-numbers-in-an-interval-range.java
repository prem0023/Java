class Solution {
    public int countOdds(int low, int high) {
        int totalNum = high - low + 1;
        int probableCount = totalNum/2;
        if(totalNum % 2 == 0){
            return probableCount;
        } else if(low % 2 == 0){
            return probableCount;
        }
         return probableCount + 1;
    }
}