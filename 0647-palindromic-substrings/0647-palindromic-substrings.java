class Solution {
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length, ans = 0;
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPallindrome(ch, i, j))
                    ans++;
            }
        }
        return ans;
    }
    
    private boolean isPallindrome(char[] ch, int left, int right){
        if(left == right)
            return true;
        
        while(left < right){
            if(ch[left] != ch[right])
                return false;
            
            left++;
            right--;
        }
        
        return true;
    }
}