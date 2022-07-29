// Generate N bit binary number having number of 1's greater than number pf 0's.



import java.util.*;

class Solution {
	
	//We can create ArrayList globally and remove from method paramer
    public static void getNbitString(int o, int z, int n, String s, ArrayList<String> al) {
        
    	if(n == 0) {
    		al.add(s);
    		return;
    	}
    	
    	String s1 = s +"1";
    	getNbitString(o+1,z,n-1,s1,al);
    	
    	if(o>z) {
    		String s2 = s +"0";
        	getNbitString(o,z+1,n-1,s2,al);
    	}
	}


	
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		getNbitString(0,0,5,"",al);
		
		Iterator<String> it = al.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
