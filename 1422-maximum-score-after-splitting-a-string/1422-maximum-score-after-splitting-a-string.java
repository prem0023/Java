class Solution {
    public int maxScore(String s) {
        int score = 0, maxSc = 0;
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '1')
                maxSc++;
        }
        
        if(s.charAt(0) == '0')
            maxSc++;
        
        score = maxSc;
        
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i) == '0')
                score++;
            else
                score--;
            
            maxSc = Math.max(maxSc, score);
        }
        
        return maxSc;
    }
}