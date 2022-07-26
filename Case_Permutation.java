//Case Permutation

class Solution {

	static void casePermutation(String s, String ans) {
		
		if(s.length() == 0) { // or if(s == "")
			System.out.println(ans);
			return;
		}

		casePermutation(s.substring(1),ans+s.charAt(0));
		
		ans = ans + Character.toString(s.charAt(0)).toUpperCase();
		
		casePermutation(s.substring(1),ans);
		
	}

	public static void main(String[] args) {
		
		String s = "ab";
		
		casePermutation(s,"");
	}
}