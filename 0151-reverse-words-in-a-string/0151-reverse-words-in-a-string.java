class Solution {
	public String reverseWords(String s) {
		int n = s.length();
		char[] res = new char[n + 1];
		char[] str = s.toCharArray();

		int pos = 0;
		int i = n - 1;
		int right, j;
		while (i >= 0) {
			while (i >= 0 && str[i] == ' ')
				i--;
			right = i;
			while (i >= 0 && str[i] != ' ')
				i--;
			for (j = i + 1; j < right; j++)
				res[pos++] = str[j];
			if (j == right) {
				res[pos++] = str[j];
				res[pos++] = ' ';
			}
		}
		return new String(res, 0, pos - 1);
	}
}

/*
class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        int l = 0, r = s.length()-1;
        int ll = 0, rr = s.length();
        String left = "";
        String right = "";

        while(l <= r){
            if(s.charAt(l) == ' '){
                left = s.substring(ll, l).trim() + " " + left;
                left = left.trim();
                ll = l;
            }
            if(s.charAt(r) == ' '){
                right = right + " " + s.substring(r, rr).trim();
                right = right.trim();
                rr = r;
            }
            else if(l == r){
                left = right + " " + s.substring(ll, rr).trim() + " " + left;
                return left.trim();
            }
            l++;
            r--;
        }
        
        if(ll < rr && s.substring(ll, rr).trim().length() > 0) {
        	left = right + " " + s.substring(ll, rr).trim() + " " + left;
        	return left;
        }
        
        left = right + " " + left;

        return (left);
    }
}

*/