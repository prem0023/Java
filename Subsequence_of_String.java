// Print Subsequence or Subset or Power Set of String

class Solution {

	static String a = "";
	static String b;
	static void findPermutation(String s, String ans) {
		
		if(s.length() == 0) { 
			System.out.println(ans);
			return;
		}
		
		char temp = s.charAt(0);
		
		findPermutation(s.substring(1),ans+temp);
		findPermutation(s.substring(1),ans);
		
		
		
	}

	public static void main(String[] args) {
		
		String s = "abc";
		//System.out.println(s.substring(1));
		
		findPermutation(s,"");
	}