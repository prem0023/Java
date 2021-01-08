
import java.util.Arrays;
import java.util.Scanner;

public class DigitPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] x = new int[N];
		
		for(int i=0;i<N;i++) {
			int n = sc.nextInt();
			int a = n%10;
			int b = (n%100)/10;
			int c = n/100;
			int big = a > b ? ( a > c ? a : c) : (b > c ? b : c) ;
			int small = a < b ? ( a < c ? a : c) : (b < c ? b : c) ;
			int m = big*11 + small*7;
			x[i] = (m%100)/10;
			//System.out.println(x[i]);
		}
		int[] a = new int[N/2+1];
		int[] b = new int[N/2+1];
		int c = 0;
		for(int i=0;i<N/2;i++) {
			a[i] = x[2*i];
			b[i] = x[2*i+1];
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int n = a.length;
		for(int i=0;i<n-1;){
			if (a[i] == a[i+1]){ 
				c++; 
			    i=i+2; 
			}
			else{ 
			    i++; 
			}
		} 
		
		int n1 = b.length;
		for(int i=0;i<n1-1;){
			if (a[i] == a[i+1]){ 
				c++; 
			    i=i+2; 
			}
			else{ 
			    i++; 
			}
		} 
		System.out.println(c);

	}

}
