package p1;
import java.util.*;
public class Replacing_Elements {

	static int check(int[] arr, int d, int n) {
		Arrays.sort(arr);
		
		if(arr[0]>d || arr[1]>d) {
			return 0;
		}
		int c=arr[0]+arr[1];
		if(c<d) {
			return 1;
		}
		for(int i=2;i<n;i++) {
			if(c>arr[i-2]+arr[i-1]) {
				c=arr[i-2]+arr[i-1];
			}
			if(arr[i]>d && c>d) {
				return 0;
			}
			if(arr[i]>d) {
				arr[i] = c;
			}
		}
		return 1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t=0;t<test;t++ ) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]= sc.nextInt();
			}
			int x = check(arr,d,n);
			if(x==0) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}

	}

}
