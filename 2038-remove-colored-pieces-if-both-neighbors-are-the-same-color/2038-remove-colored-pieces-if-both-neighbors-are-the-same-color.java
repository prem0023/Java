class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0, i=0;
        int n = colors.length();
        
        while(i < n){
            int a = 0;
            while(i < n && colors.charAt(i) == 'A'){
                a++;
                i++;
            }
            if(a > 2)
                alice  += a-2;
            
            a = 0;
            while(i < n && colors.charAt(i) == 'B'){
                a++;
                i++;
            }
            if(a > 2)
                bob  += a-2;
        }
        
        return alice > bob;
    }
}