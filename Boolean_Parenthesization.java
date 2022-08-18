// Evaluate Expression to True Boolean Parenthesization

class Solution{
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    static int countWays(int n, String s){
        // code here
        hm.clear();
     
        return getcountWays(s, 0, n-1, true);
    }
    
    static int getcountWays(String s, int i, int j, boolean tru){
        
        if(i > j)
            return 0;
        
        if(i == j) {
        	if(tru){
        	    if(s.charAt(i) == 'T')
        	        return 1;
        	}
        	else{ 
        	    if(s.charAt(i) == 'F')
        	        return 1;
        	}
        	return 0;	
        }
        String key = new String(i + " " + j + " " + tru);
        //String key = i + " " + j + " " + Boolean.toString(tru);
            
        if(hm.containsKey(key))
            return hm.get(key);
        
        
            
        int cost = 0;
        
        for(int k=i+1; k<j; k=k+2){
            
            int lt = getcountWays(s, i, k-1, true);
            int lf = getcountWays(s, i, k-1, false);
            int rt = getcountWays(s, k+1, j, true);
            int rf = getcountWays(s, k+1, j, false);
            
            char c = s.charAt(k);
            
            if(c == '|'){
                if(tru)
                    cost = cost + lt*(rt+rf) + lf*rt;
                else
                    cost = cost + lf*rf;
            }
            else if(c == '&'){
                if(tru)
                    cost = cost + lt*rt;
                else
                    cost = cost + lf*(rt+rf) + lt*rf;
            }
            else{
                if(tru)
                    cost = cost + lt*rf + lf*rt;
                else
                    cost = cost + lt*rt + lf*rf;
            }
            
        }
        hm.put(key, cost%1003);
            
        return cost%1003;
    }

    
    public static void main(String[] args) {
    	
    	String s = "T|T&F^T^T^F|F&T^F|T&F&T^T&T^F&F";
    	System.out.println(countWays(s.length(), s));
    	
    }
}