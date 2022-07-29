// Get Josephus Number

import java.util.*;

class Solution {
	
    public static int findJosephus(ArrayList<Integer> al, int k, int i) {
        
    	if(al.size() == 1)
    		return al.get(0);
    	
    	int j = (k+i-1) % al.size();
    	al.remove(j);
    	
    	//i = j % al.size(); (optional)
    	
    	return findJosephus(al,k,i);
    	
	}


	
	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=1;i<=40;i++) {
			al.add(i);
		}
		
		
		System.out.println(findJosephus(al,7,0));
		
		
	}
}
