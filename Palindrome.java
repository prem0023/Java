import java.util.*;
public class Palindrome {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        StringBuffer s = new StringBuffer(A);
        String B = (s.reverse()).toString();
        sc.close();
        
        if(A.compareTo(B)==0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        

	}

}
