class Solution {
     public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        boolean[][] dp = new boolean[len][len];
        int ml = 0;
        int mr = 0;
        for (int r = 0; r < len; r++) {
            dp[r][r] = true;
            for (int l = 0; l < r; l++) {
                // l  r
                // abca ...  //a = a, ok
                if (s.charAt(l) != s.charAt(r)) continue;
                // l  r
                // abca ...   //b != c continue
                if (l + 1 < r - 1 && !dp[l + 1][r - 1]) continue;
                dp[l][r] = true;
                if (r - l > mr - ml) {
                    ml = l;
                    mr = r;
                }
            }
        }
        return s.substring(ml, mr + 1);
    }
}