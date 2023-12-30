class Solution {
    public boolean makeEqual(String[] words) {
        int[] ch = new int[26];
        int n = words.length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<words[i].length(); j++)
                ch[words[i].charAt(j) - 'a']++;
        }
        
        // System.out.println(Arrays.toString(ch));
        
        for(int i=0; i<26; i++){
            if(ch[i] % n != 0)
                return false;
        }
        return true;
    }
}