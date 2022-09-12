// Infix to Postfix

// Metyhod 1
class Solution {
  // Function to convert an infix expression to a postfix expression.
  
  public static String infixToPostfix(String s) {
		// Your code here

		Stack<Character> st = new Stack<>();
		String ans = new String();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		hm.put('+', 1);
		hm.put('-', 1);
		hm.put('*', 2);
		hm.put('/', 2);
		hm.put('^', 3);
		hm.put('(', 4);

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				ans += s.charAt(i);
			} 
			else if (s.charAt(i) == '(') {
				st.push(s.charAt(i));
			} 
			else if (s.charAt(i) == ')') {
				while (!st.empty() && st.peek() != '(') {
					ans += st.pop();
				}
				if (!st.empty()) {
					st.pop();
				}
			} 
			else {
				while (!st.empty() && hm.get(st.peek()) >= hm.get(s.charAt(i)) && st.peek() != '(') {
					ans += st.pop();
				}

				st.push(s.charAt(i));
			}
		}

		while (!st.empty()) {
			ans += st.pop();
		}
		return ans;
  }
}


/*
// Method 2
class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        Stack<Character> st = new Stack<Character>();
        String postfix = "";
        
        hm.put('+',1);
        hm.put('-',1);
        hm.put('*',2);
        hm.put('/',2);
        hm.put('^',3);
        hm.put('(',4);
        
        for(int i=0; i<exp.length(); i++){
            int a = (int)exp.charAt(i);
            if(exp.charAt(i) == ')'){
                while(st.peek() != '('){
                    postfix = postfix + st.pop();
                }
                st.pop();
            }
            else if(a < 48 || a == 94){
                if(!st.isEmpty()){
                    if(hm.get(st.peek()) >= hm.get(exp.charAt(i))){
                        if(exp.charAt(i) == '^')
                            st.push(exp.charAt(i));
                        else{
                            while(!st.isEmpty() && hm.get(st.peek()) >= hm.get(exp.charAt(i)) && st.peek() != '(')
                                postfix = postfix + st.pop();
                            st.push(exp.charAt(i));
                        }
                    }
                    else{
                        st.push(exp.charAt(i));
                    }
                }
                else
                    st.push(exp.charAt(i));
            }
            else{
                postfix = postfix + exp.charAt(i);
            }
        }
        while(!st.isEmpty())
            postfix = postfix + st.pop();
 
        return postfix;
    }
}
*/