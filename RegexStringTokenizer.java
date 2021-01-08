import java.util.StringTokenizer;

public class RegexStringTokenizer {
	public static void main(String args[]) {
		StringTokenizer st = new StringTokenizer("My Name is Prem Kumar");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
