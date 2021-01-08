
public class RegecSplit2 {

	public static void main(String[] args) {
		String s = "My name is Prem Kumar";
		String [] s1 = s.split("\\s");
		for(String s2 : s1) {
			System.out.println(s2);
		}

	}

}
