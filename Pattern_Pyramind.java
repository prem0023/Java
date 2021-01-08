import java.util.Scanner;

public class Pattern_Pyramind {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int n = sc.nextInt();
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<n-i;k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			for(int k=i;k>0;k--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		sc.close();
	}

}
