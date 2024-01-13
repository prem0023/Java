class Solution {
    public int minSteps(String s, String t) {
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            sArray[s.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<t.length(); i++){
            tArray[t.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<26; i++){
            if(sArray[i] <= tArray[i])
                continue;
            
            ans += (sArray[i] - tArray[i]);
        }
        
        // System.out.println("sArray: " + Arrays.toString(sArray));
        // System.out.println("tArray: " + Arrays.toString(tArray));
        
        return ans;
    }
}