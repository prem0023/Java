// Permutation with Spaces

class Solution {

	//Method - 1
	static void spacePermutation(String s, int i) {
		
		if(s.length() <= i) {
			
			System.out.println(s);
			return;
		}
		
		spacePermutation(s,i+1);
		String s1 = s.substring(0, i) + "_" + s.substring(i);
		spacePermutation(s1,i+2);
		
		return;
		
		
		
	}

	public static void main(String[] args) {
		
		String s = "abc";
		
		spacePermutation(s,1);
	}
}

// Method - 2
/*
static void spacePermutation(String s, String ans) {
		
		if(s.length() == 1) {
			System.out.println(ans + s.charAt(0));
			return;
		}
		
		spacePermutation(s.substring(1),ans+s.charAt(0));
		
		spacePermutation(s.substring(1),ans+s.charAt(0)+"_");
		
		
	}
*/

// Method - 3
/*

class Solution {

	static void spacePermutation(String s, String ans) {
		
		if(s.length() == 0) { // or if(s == "")
			System.out.println(ans);
			return;
		}
		
		spacePermutation(s.substring(1),ans+s.charAt(0));
		
		spacePermutation(s.substring(1),ans+"_" + s.charAt(0));
		
		
	}

	public static void main(String[] args) {
		
		String s = "abc";
		
		spacePermutation(s.substring(1),"a");
	}
}

*/