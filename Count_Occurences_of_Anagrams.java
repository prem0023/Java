//Count Occurences of Anagrams


class Solution {

    int search(String pat, String txt) {
        // code here
        int ans = 0;
        int m = pat.length();
        int start = 0;
        int end = 0;
        int counter = m;
        int[] arr = new int[26];
        
        for(int i=0; i<m; i++)
            arr[pat.charAt(i)-97]++;
            
        while(end < txt.length()){
            if(arr[txt.charAt(end)-97] > 0)
                counter--;
            arr[txt.charAt(end)-97]--;
            
            if(end-start == m-1){
                if(counter == 0)
                    ans++;
                if(arr[txt.charAt(start)-97] >= 0)
                	counter++;
                arr[txt.charAt(start)-97]++;
                start++;
            }
            end++;
        }
        return ans;
    }
    
    
}
/*
// Method 2
class Solution {

	int search(String pat, String txt) {
		// code here
		int start = 0;
		int end = pat.length();
		int ans = 0;
		int c = 0;

		while (end <= txt.length()) {
			if (c == 1) {
				if (txt.charAt(end - 1) == txt.charAt(start - 1))
					ans++;
				else
					c = 0;
			} else if (areAnagram(pat, txt.substring(start, end))) {
				ans++;
				c = 1;
			}

			start++;
			end++;
		}
		return ans;
	}

	static boolean areAnagram(String str1, String str2) {

		int[] count = new int[26];

		for (int i = 0; i < str1.length(); i++) {
			count[str1.charAt(i) - 97]++;
			count[str2.charAt(i) - 97]--;
		}

		for (int i = 0; i < 26; i++)
			if (count[i] != 0) {
				return false;
			}
		return true;
	}
}
*/