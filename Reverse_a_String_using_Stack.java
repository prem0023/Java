// Reverse a string using Stack

class Solution {
    
    public String reverse(String s){
        //code here
        int n = s.length();
        if(n == 1)
            return s;
            
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i<n; i++){
            st.push(s.charAt(i));
        }
        
        s = "";
        while(!st.isEmpty())
            s = s + st.pop();
            
        return s;
    }

}