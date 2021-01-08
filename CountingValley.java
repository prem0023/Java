import java.io.DataInputStream;
import java.io.IOException;

public class CountingValley {

	public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(System.in);
        int n = Integer.parseInt(dis.readLine());
        String s = dis.readLine();
        int c = 0;
        int c1 = s.charAt(0)=='D'?-1:1;
    
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='U'){
                c1++;
                if(c1==0){
                    c++;   
                }                                             
            }
            else{
                c1--;
            }
        }
        System.out.println(c);
    }

}
