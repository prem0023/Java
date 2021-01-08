
import java.util.*;

class Codechef
{
	static long sum(int N) {
		long sum=0;
		long r3 = N/3;
		long r5 = N/5;
		long r15 = N/15;
		long sum3 = (r3 * (2*3 + (r3-1)*3))/2;
		long sum5 = (r5*(2*5 + (r5-1)*5))/2;
		long sum15 = (r15*(2*15 + (r15-1)*15))/2;
		sum = sum3+sum5-sum15;
		return sum;
	        
	}
			
		
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
		    int N = sc.nextInt();
		    System.out.println(Codechef.sum(N));
		    }
		sc.close();
	}
}