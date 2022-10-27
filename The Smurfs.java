// The Smurfs

class Solution{
    static int minFind(int n, String a[]){
        // code here
        int r = 0, g = 0, b = 0;
        for(int i = 0; i<n; i++) {
        	if(a[i].equals("R"))
        		r++;
        	else {
        		if(a[i].equals("G"))
        			g++;
        		else
        			b++;
        	}
        }
        return (r%2 == g%2 && g%2 == b%2) ? 2 : 1;
    }
}