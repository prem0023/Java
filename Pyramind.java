package p1;
import java.util.Scanner;

public class Pyramind {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int c=0;
		for(int i=1;i<=n;i++) {
			for(int k=i;k<n;k++) {
				System.out.print(" ");
			}
			for(int j=i;j<2*i;j++) {
				System.out.print(j);
			}
			for(int j=2*i-2;j>=i;j--) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		sc.close();

	}

}


/* 1
  232
 34543
 */
