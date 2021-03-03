package p1;
import java.util.Scanner;;
public class ElixirOfLife {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String sn ="";
		int n =s.length();
		for(int i=0;i<n;i++) {
			String s1 = s.substring(0,i+1);
			String s2 = s.substring(n-i-1,n);
			if(s1.equals(s2)) {
				sn=s1;
				break;
			}
		}
		int n1 = sn.length();
		int c=0;
		for(int i=0;i<=n-n1;i++) {
			String sn1 = s.substring(i,i+n1);
			if(sn1.equals(sn)) {
				c++;
			}
		}
		if(c==0) {
			c++;
		}
		System.out.println(c);
		
		sc.close();

	}

}
