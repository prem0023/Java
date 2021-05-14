import java.util.Scanner;

class LongestPalindromeString{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(longestPalin(s));
	}
    static boolean check(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    static String longestPalin(String S){
        String k="";
        int n = S.length();
        if(check(S) == true){
            return S;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String s1 = S.substring(i,j);
                if(check(s1) == true){
                    if(k.length()<s1.length()){
                        k = s1;
                    }
                }
            }
        }
        return k;
    }
}