import java.util.Scanner;
import java.util.regex.*;
public class Regex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the target String");
		String s1 = sc.nextLine();
		System.out.println("Enter the Pattern you want to search");
		String s2 = sc.nextLine();
		Pattern p = Pattern.compile(s2);
		Matcher m = p.matcher(s1);
		int count = 0;
		while(m.find()) {
			count += 1;
			System.out.println(m.start()+" "+(m.end()-1)+" "+m.group());
		}
		if(count==0) {
            System.out.println("Pattern did not found..!!");
		}
		

	}

}
