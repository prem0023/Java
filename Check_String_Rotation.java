import java.util.*;

class Check_String_Rotation
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int c = check(s1,s2);
		if(c==0){
			System.out.println("NO");
		}
		else{
			System.out.println("YES");
		}
	}
	static int check(String s1, String s2){
		if(s1.length() != s2.length()){
			return 0;
		}
		else if(s1.equals(s2)){
			return 1;
		}
		else{
			int n = s1.length();
			for(int i=1;i<n-1;i++){
				String s3 = s1.substring(i,n) + s1.substring(0,i);
				if(s3.equals(s2)){
					return 1;
				}
			}
		}
		return 0;
	}
		
}