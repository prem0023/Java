public class Solution {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }

    }
}

/*
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
*/