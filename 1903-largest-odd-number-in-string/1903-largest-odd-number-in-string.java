class Solution {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1; i>=0; i--){
            int x = num.charAt(i) - '0';
            
            if(x % 2 == 1){
                return num.substring(0, i+1);
            }
        }
        
        return "";
    }
}