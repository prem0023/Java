// Evaluation of Postfix Expression

class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<S.length(); i++){
            if(Character.isDigit(S.charAt(i)))
                st.push(Character.getNumericValue(S.charAt(i)));
            else{
                int b = st.pop();
                int a = st.pop();
                st.push(eval(a, b, S.charAt(i)));
            }
        }
        
        return st.pop();
    }
    
    public static int eval(int a, int b, char op){
        if(op == '+')
            return a + b;
      
        else if(op == '-')
        	return a - b; 
        
        else if(op == '*')
        	return a * b; 

        else if(op == '/')
        	return a / b;
        
        else if(op == '^')
        	return a ^ b;
        
        return 0;
    }
}