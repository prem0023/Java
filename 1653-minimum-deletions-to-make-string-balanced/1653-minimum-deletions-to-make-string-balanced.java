class Solution {
    public int minimumDeletions(String s) {
        int ans = 0, countOfB = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a') {
                ans = Math.min(ans + 1, countOfB);
            } else {
                countOfB++;
            }
        }
        return ans;
    }
}