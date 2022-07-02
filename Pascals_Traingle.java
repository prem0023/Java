// Pascal's Traingle

class Pascals_Traingle {

	public static void main(String[] args) {
		int n = 5;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				int a = fact(i)/(fact(j)*fact(i-j));
				//System.out.print(a + "  ");
			}
			System.out.println();
		}
		//sc.close();
	}
	
	public static int fact(int n) { 
		if(n<2)
			return 1;
		int fact = 1;
		for(int i=1;i<=n;i++){    
		    fact=fact*i;    
		}
		return fact;
	}

}

