//Is duplicate Parenthesis present in String

class Solution {
	static boolean isDuplicateParenthesis(String s) {
		int count = 1;
		int n = s.length();
		int i = 1;
		int c = 0;
		
		while(i<n) {
			if(i<n-2){
                if(s.charAt(i) == '(' && s.charAt(i+1) != ')' && s.charAt(i+2) == ')') {
                    i++;
                    i++;
                    continue;
                }
            }
			if(count == 1)
				c=0;
			if(s.charAt(i) == '(')
				count++;
			if( s.charAt(i) == ')')
				count--;
			if(s.charAt(i-1) == ')' && s.charAt(i) == ')' && c == 1)
				return true;
			if(s.charAt(i-1) == '(' && s.charAt(i) == '(')
				c = 1;
			i++;
		}
		return false;
	}

    
    
    public static void main(String[] args) {
    	//String s = "((a+b)+((c+d)))";
    	//String s = "(((a+b)+c)+(a+b))";
		//String s = "(((a+b)+c)+((a+b)))";
    	String s =  "(((a+(b)))+(c+d))";
    	System.out.println(isDuplicateParenthesis(s));

    }
}




// For checking Duplicate Parenthesis Combination

	static boolean isDuplicateParenthesis(String s) {
		int c = 0;
		int n = s.length();
		int i = 0;
		
		while(i<n) {
			if(s.charAt(i) == '(')
				c++;
			else if(s.charAt(i) == ')')
				c--;
			
			if(c <0)
				return true;
			i++;
		}
		if(c != 0)
			return true;
		
		return false;
	}
