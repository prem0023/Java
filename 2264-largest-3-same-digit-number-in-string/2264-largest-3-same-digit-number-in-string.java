class Solution {
    public String largestGoodInteger(String num) {
        int count = 1;
        char[] ch = num.toCharArray();
        char maxNum = 'a';
        
        for(int i=1; i<ch.length; i++){
            if(ch[i-1] == ch[i]){
                if(count >= 2 && (maxNum < ch[i] || maxNum == 'a'))
                    maxNum = ch[i];
                count++;
            }
            else
                count = 1;
        }
        
        if(maxNum == 'a')
            return "";
        
        return "" + maxNum + maxNum + maxNum;
    }
}