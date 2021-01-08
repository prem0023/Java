import java.util.Scanner;

public class Anagram {

    static boolean isAnagram(String A, String B) {
        String a = A.toLowerCase();
        String b = B.toLowerCase();
        if(a.length()!=b.length()){
            return false;
        }
        else{
            int x = 0;
            int y[] = new int[100];
            for(int i = 0;i<a.length();i++){
                for(int j = 0;j<a.length();j++){
                    if(a.charAt(i)==a.charAt(j)){
                       x = x+1; 
                    }
                }
                y[i] = x;
                x = 0;
            }

            int m = 0;
            int n[] = new int[100];
            for(int i = 0;i<a.length();i++){
                for(int j = 0;j<a.length();j++){
                    if(b.charAt(i)==b.charAt(j)){
                       m = m+1; 
                    }
                }
                n[i] = m;
                m = 0;
            }
            int k = 0;
            int p = 0;
            for(int i=0;i<a.length();i++){
                for(int j=0;j<a.length();j++){
                    if(a.charAt(i)==b.charAt(j)){
                        p = p+1;
                        if(y[i]!=n[j]){
                            k = k+1;
                        }
                    }
                    else if(i == a.length()-1 && p ==0 ){
                        return false;
                    }
                }
            }
            if(k==0){
                return true;
            }
            else{
                return false;
            }
        }
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
