package p1;
import java.util.Scanner;

public class Hollow_Pyramind {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int c=0;
		for(int i=1;i<=n;i++) {
			for(int k=i;k<=n;k++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for(int j=1;j<2*i-2;j++) {
				System.out.print(" ");
			}
				if(i==1)
					System.out.println();
				else
					System.out.println("*");
		}
		System.out.print(" ");
		for(int i=0;i<2*n-1;i++) {
			System.out.print("*");
		}
		
		sc.close();

	}

}


/* 1
  232
 34543
 */
