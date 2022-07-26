// Case Permutation of Alphanumeric

class Solution {

	static void casePermutationAlphaNumeric(String s, String ans) {
		
		if(s == "") {
			System.out.println(ans);
			return;
		}
		
		
		
		int c = Character.getNumericValue(s.charAt(0));
		if(c>9) {
			casePermutationAlphaNumeric(s.substring(1), ans+ Character.toString(s.charAt(0)).toLowerCase());
			casePermutationAlphaNumeric(s.substring(1), ans+ Character.toString(s.charAt(0)).toUpperCase());
		}
		else
			casePermutationAlphaNumeric(s.substring(1), ans+ s.charAt(0));
	}

	public static void main(String[] args) {
		
		String s = "a2b7M";
		
		casePermutationAlphaNumeric(s,"");
	}
}

// Using ArrayList

import java.util.*;

class Solution {

	static ArrayList<String> arr = new ArrayList<String>();
	
	static ArrayList<String> casePermutationAlphaNumeric(String s, String ans) {
		
		if(s == "") {
			arr.add(ans);
			return arr;
		}
		
		
		
		int c = Character.getNumericValue(s.charAt(0));
		if(c>9) {
			arr = casePermutationAlphaNumeric(s.substring(1), ans+ Character.toString(s.charAt(0)).toLowerCase());
			arr = casePermutationAlphaNumeric(s.substring(1), ans+ Character.toString(s.charAt(0)).toUpperCase());
		}
		else
			arr = casePermutationAlphaNumeric(s.substring(1), ans+ s.charAt(0));
		
		return arr;
	}

	public static void main(String[] args) {
		
		String s = "a2b7M";
		
		ArrayList<String> arr = new ArrayList<String>();
		
		arr = casePermutationAlphaNumeric(s,"");
		
		Iterator<String> it = arr.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//System.out.println(Arrays.toString(arr));
	}
}
