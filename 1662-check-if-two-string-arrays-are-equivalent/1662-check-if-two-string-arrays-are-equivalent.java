class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s = "", t = "";
        
        for(int i=0; i<word1.length; i++){
            s += word1[i];
        }
        
        for(int i=0; i<word2.length; i++){
           t += word2[i];
        }
        
        return s.equals(t);
    }
}