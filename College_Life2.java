package p1;

import java.util.Scanner;

public class College_Life2 {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int s=0;
		int sum=0;
		int e=0;
		int[] q = null;
		int[] ep = null;
		int t =  sc.nextInt();
		for(int i=0;i<t;i++){
		    s = sc.nextInt();
		    q = new int[s];
		    for(int j=0;j<s;j++){
		        q[j] = sc.nextInt();
		    }
		    for(int j=0;j<s;j++){
		        e = sc.nextInt();
		        ep = new int[e];
		        for(int k=0;k<e;k++){
		            ep[k] = sc.nextInt();
		        }
		       sum = sum + findsum(q[j],e,ep); 
		    }
		   System.out.println(sum);
		   sum=0; 
		}
		sc.close();
	}
	
	static int findsum(int q, int e, int[] ep){
	    int c=0;
	    for(int j=0;j<e;j++){
	        c = c+ep[j]-q;
	    }
	    c = c+q;
	    return c;
	}
}
