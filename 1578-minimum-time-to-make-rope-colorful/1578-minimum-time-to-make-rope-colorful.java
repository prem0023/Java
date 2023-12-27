class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0, j = 0;
        char[] ch = colors.toCharArray();
        
        for(int i=1; i<ch.length; i++){
            if(ch[i] == ch[j]){
                if(neededTime[j] < neededTime[i]){
                    ans += neededTime[j];
                    j = i;
                }
                else{
                    ans += neededTime[i];
                }
            }
            else{
                j = i;
            }
        }
        
        return ans;
    }
}