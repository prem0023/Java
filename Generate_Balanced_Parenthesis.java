// Generate Balanced Parenthesis

import java.util.*;


//Method - 1

import java.util.*;

class Solution {
	
    public static void getBalancedParenthesis(int op, int cl, String s, ArrayList<String> al) {
        
        if(op == 0 && cl == 0) {
        	al.add(s);
        	return;
        }
        
        if(op>0) {
        	String s1 = s +"(";
            getBalancedParenthesis(op-1,cl,s1,al);
        }
        
        if(cl>op) {
        	String s2 = s +")";
            getBalancedParenthesis(op,cl-1,s2,al);
        }
        
        return;
	}

    
	
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		getBalancedParenthesis(3,3,"",al);
		
		Iterator<String> it = al.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}



// Method - 2


class Solution {
	
    public static void getBalancedParenthesis(int op, int cl, String s, ArrayList<String> al) {
        
        if(op == 0 && cl == 0) {
        	if(s.charAt(0) == '(' && s.charAt(s.length()-1) == ')') {
        		if(!isDuplicateParenthesis(s))
        			al.add(s);
        	}
        	return;
        }
        
        if(op>0) {
        	String s1 = s +"(";
            getBalancedParenthesis(op-1,cl,s1,al);
        }
        
        if(cl>0) {
        	String s2 = s +")";
            getBalancedParenthesis(op,cl-1,s2,al);
        }
        
        return;
	}

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
		if(c !=0)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		getBalancedParenthesis(5,5,"",al);
		
		System.out.println(isDuplicateParenthesis("()(())()(()"));
		
		Iterator<String> it = al.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
