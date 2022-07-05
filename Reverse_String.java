// Reverse String

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i=0;i<n/2;i++){
            if(s[i] == s[n-1-i])
                continue;
            char c = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = c;
        }
        
    }
}


class Solution {
    public void reverseString(char[] s) {
      
        int l=0;int r=s.length-1;
        while(l<r){
           char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
            
        }
        
        
    }
}