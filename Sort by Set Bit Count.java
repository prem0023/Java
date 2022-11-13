class Compute  
{ 
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
        Arrays.sort(arr,(a,b)->{
            a = Integer.bitCount(a);
            b = Integer.bitCount(b);
            
            if(a>b)
                return -1;
            else if(b>a)
                return 1;
            return 0;
        });
    } 
}

/*
class Compute  
{ 
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
        Arrays.sort(arr, (a, b) ->{
	
			int x = countOne(s1);
		    int y = countOne(s2);
			
			if(x>y)
			    return -1;
			else if(x<y)
			    return 1;
			return 0;
		});
    } 
    
    static int countOne(String s) {
    	int count = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) == '1')
    			count++;
    	}
    	return count;
    }
}
*/
