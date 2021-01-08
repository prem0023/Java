import java.util.regex.*;
import java.util.Scanner;

public class RegexSplit1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Target String");
		String p1 = sc.nextLine();
		System.out.println("Enter the Splitting condition");
		String q = sc.nextLine();
		//String q = "\\s";
		Pattern p = Pattern.compile(q);
		String[] s = p.split(p1);
		for( String s1 : s) {
			System.out.println(s1);
		}

	}

}
