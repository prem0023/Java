//Defense of a Kingdom

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-->0){
		    int w = sc.nextInt();
		    int h = sc.nextInt();
		    int g = sc.nextInt();
		    
		    int[][] a = new int[g][2];
		        for(int i=0;i<g;i++){
		            a[i][0] = sc.nextInt();
		            a[i][1] = sc.nextInt();
		        }
		    
		    System.out.println(findPenalty(a,g,h,w));
		}
	}
	
	static int findPenalty(int[][] a, int g, int h, int w){
	    int[] row = new int[g+2];
	    int[] col = new int[g+2];
	    
	    row[0] = 0;
	    col[0] = 0;
	    
	    for(int i=1;i<g+1;i++){
	        row[i] = a[i-1][0];
	        col[i] = a[i-1][1];
	    }
	    row[g+1] = w+1;
	    col[g+1] = h+1;
	    
	    Arrays.sort(row);
	    Arrays.sort(col);
	    
	    int n = 0;
	    int m = 0;
	    for(int i=1;i<g+2;i++){
	        if(row[i]-row[i-1]>n)
	            n = row[i]-row[i-1];
	        if(col[i]-col[i-1] > m) 
	           m = col[i]-col[i-1];
	    }
	    
	    return (m-1)*(n-1);
	}
}