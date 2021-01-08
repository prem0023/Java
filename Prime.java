import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Find_prime a = new Find_prime();
		a.fun(n);	
	}
}
class Find_prime {
	void fun(int x) {
		for(int i=2;i<x;i++) {
			if(x%i==0) {
				System.out.print(x +" is not prime number." );
				break;
			}
		}
		//System.out.print(x +" is prime number." );
		
	}
}

