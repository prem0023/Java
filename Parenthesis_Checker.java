// Parenthesis Checker

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int n = s.length();
        
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else{
                if(st.isEmpty())
                    return false;
                    
                char ch = st.pop();
                
                if(s.charAt(i) == '}'){
                    if(ch != '{')
                        return false;
                }
                else if(s.charAt(i) == ')'){
                    if(ch != '(')
                        return false;
                }
                else{
                    if(ch != '[')
                        return false;
                    
                }
            }
        }
        if(!st.isEmpty())
            return false;
            
        return true;
    }
}