class Solution {
    public boolean makeEqual(String[] words) {
        int[] ch = new int[26];
        
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++)
                ch[words[i].charAt(j) - 'a']++;
        }
        
        for(int i=0; i<26; i++){
            if(ch[i] % words.length != 0)
                return false;
        }
        return true;
    }
}