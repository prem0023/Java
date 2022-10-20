// Non Repeating Character

class Solution {
	// Function to find the first non-repeating character in a string.
	static char nonrepeatingCharacter(String S) {
		// Your code here
		for (int i = 0; i < S.length(); i++) {
			boolean unique = true;
			char n = '$';
			for (int j = 0; j < S.length(); j++) {
				if (i != j && S.charAt(i) == S.charAt(j)) {
					unique = false;
					break;
				}
			}
			if (unique) {
				return S.charAt(i);
			} else {
				n = '$';
			}
		}
		return '$';
	}
}

/*
import java.util.TreeMap;

class Solution {
	// Function to find the first non-repeating character in a string.
	static char nonrepeatingCharacter(String S) {
		// Your code here
		TreeMap<Character, Integer> hm = new TreeMap<Character, Integer>();

		for (int i = 0; i < S.length(); i++) {
			hm.put(S.charAt(i), hm.getOrDefault(S.charAt(i), 0) + 1);
		}
		// }
		for (int i = 0; i < S.length(); i++) {
			if (hm.get(S.charAt(i)) == 1)
				return S.charAt(i);
		}
		return '$';
	}
}
*/