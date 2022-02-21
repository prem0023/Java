
import java.util.*;

class SherlockNumber {
	public static boolean find(int n) {
		int sum=0;
		while(n>0) {
			sum =  sum + n%10;
			n = n/10;
		}
		if(sum%2 == 0) {
			return true;
		}
		return false;
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int c=0;
    	for(int i=0;i<=n;i++) {
    		if(find(i)) {
    			c++;
    		}
    	}
    	System.out.println(c);
    }
}