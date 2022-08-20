// Scrambled String

class Solution {
    HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(s1).append(s2);
        String key = sb.toString();
        
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        
        if(s1.equals(s2))
    		return true;
        
    	int n = s1.length();
    	if(n <= 1)
    		return false;
        
        int[] letters = new int[26];
        for (int i = 0; i < n; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        
        boolean bool = false;
    	
        for(int i=0; i<n-1; i++) {
        	
        	boolean bool1 = isScramble(s1.substring(0,i+1), s2.substring(0,i+1)); 
        	boolean bool2 = isScramble(s1.substring(i+1), s2.substring(i+1));
        	
        	if(bool1 && bool2){
        		bool = true;
                break;
            }
        	
        	else {
        		bool1 = isScramble(s1.substring(0,i+1), s2.substring(n-i-1)); 
            	bool2 = isScramble(s1.substring(i+1), s2.substring(0, n-i-1));
                
            	if(bool1 && bool2){
            		bool = true;
                    break;
                }
        	}
        }
        hm.put(key, bool);
        return bool;
    }
	
	public static void main(String[] args) {
    	
    	String s1 = "abbbcbaaccacaacc";
    	String s2 = "acaaaccabcabcbcb";
    	
    	Solution sol = new Solution();
    	
    	System.out.println(sol.isScramble(s1, s2));
    }
    
}

/*
class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1).append(s2);
        String key = sb.toString();
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && (isScramble(s1.substring(i), s2.substring(i))) ||
               isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
*/