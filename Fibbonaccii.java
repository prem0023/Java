import java.util.Scanner;
class fib {
	int n;
	int fun(int n) {
		if(n==0 )
			return 0;
		else if(n==1)
			return 1;
		else 
			return(fun(n-1)+fun(n-2));
	}
}
public class Fibbonaccii {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		fib obj = new fib();
 		for(int i = 0; i<m;i++) {
			System.out.print(obj.fun(i)+ " ");
		}
		
		
	}

}
