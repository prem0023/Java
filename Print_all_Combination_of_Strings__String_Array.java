// Print all Combination of Strings in String Array

import java.util.*;

class Solution {

	static ArrayList<String> getCombination(Map<Integer, String> map, int n) {

		ArrayList<String> temp = new ArrayList<String>();
		int x = n;
		
		while(x > 0) {
			temp.add(map.get(x%10));
			x = x/10;
		}
		Collections.reverse(temp);
		temp = getAllCombination(temp);

		return temp;
	}

	public static ArrayList<String> getAllCombination(ArrayList<String> list) {

		ArrayList<String> temp = new ArrayList<>();
		helper(list, temp, 0, "");
		return temp;
	}

	public static void helper(ArrayList<String> l, ArrayList<String> r, int size, String str) {
		if (size == l.size()) {
			r.add(str);
			return;
		}
		else if (size > 0) {
			r.add(str);
		}
		
		for (int i = 0; i < l.get(size).length(); i++)
			helper(l, r, size + 1, str + l.get(size).charAt(i));
	}

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "xyz");

		ArrayList<String> list = new ArrayList<String>();

		list = getCombination(map, 23);
		Collections.sort(list);
		
		for(String s : list) {
			System.out.println(s);
		}

	}
}