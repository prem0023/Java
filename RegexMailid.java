import java.util.Scanner;
import java.util.regex.*;

public class RegexMailid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any email Id:");
		String n = sc.nextLine();
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher m = p.matcher(n);
		if(m.find()&&m.group().equals(n)) {
			System.out.println("Valid Email Id");
		}
		else {
			System.out.println("Invalid Email Id..!!");
		}

	}

}
