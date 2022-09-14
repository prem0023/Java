// Valid Substring

class Solution {
    static int findMaxLen(String s) {
        // code here
        int c = 0;
        int i = 0;
        int max = 0;
        
        Stack<Character> st = new Stack<Character>();
        
        while(i < s.length()){
            st.push(s.charAt(i));
            
            if(s.charAt(i) == '(')
                c++;
            else
                c--;
                
            if(c<0){
                st.pop();
                max = Math.max(max, st.size());
                st.clear();
                c = 0;
            }
            i++;
        }
        if(c == 0)
            max = Math.max(max, st.size());

        else if(c>0){
            i = 0;
            c = 0;
            while(!st.isEmpty()){
                if(st.pop() == ')')
                    c++;
                else
                    c--;
                i++;
                if(c < 0){
                    max = Math.max(max, i-1);
                    i = 0;
                    c = 0;
                }
            }
            if(c == 0)
                max = Math.max(max, i);
        }
        return max;
    }
}