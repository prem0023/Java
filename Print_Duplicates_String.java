// Print all duplicates of string

public class Solution {
	/* Print duplicates present
	in the passed string */
	static void printDups(String str)
	{
		HashMap<Character, Integer> hm = new HashMap();
		int n = str.length();
		
		for(int i=0;i<n;i++) {
			if(hm.get(str.charAt(i)) == null) {
				hm.put(str.charAt(i), 1);
				continue;
			}	
			hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
		}
		//Method 1
		Set<Map.Entry<Character, Integer>> val = hm.entrySet();
		
		for(Map.Entry<Character, Integer> e : val) {
			if(e.getValue() > 1) {
				System.out.println(e.getKey() + " , count = "+ e.getValue());
			}
		}
		
		//Method 2
		/*
		for(int i =0;i<n;i++) {
			if(hm.get(str.charAt(i)) > 1) {
				System.out.println(str.charAt(i) +" , count = "+ hm.get(str.charAt(i)));
				hm.put(str.charAt(i), 1);
			}
		}
		*/
	}

	// Driver Method
	public static void main(String[] args)
	{
		String str = "test sttpoairing";
		printDups(str);
	}
}
