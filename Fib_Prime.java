import java.util.Scanner;

class Fib_Prime
{
	static int prime(int n) {
		boolean t = true;
		int c = 0;
		while(t) {
			for(int i=2;i<n;i++) {
				if(n%i==0) {
					c=1;
				}
			}
			if(c==0) {
				t = false;
				c=0;
			}
			else {
				n++;
				c=0;
			}
		}
		return n;
	}
	static int fib(int n) {
		if(n<=1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	//1, 2, 1, 3, 2, 5, 3, 7, 5, 11, 8, 13, 13, 17
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of term to print: ");
		int n = sc.nextInt();
		int x=1;
		for(int i=1;i<=n;i++) {
			if(i%2==0) {
				x = prime(x+1);
				System.out.print(x+" ");
			}
			else {
				System.out.print(fib(i/2 + 1)+" ");
			}
			//System.out.print("z");
		}
		
		sc.close();
	}
}