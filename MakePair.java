import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class MakePair {

	public static void main(String[] args) throws IOException{
        DataInputStream dis = new DataInputStream(System.in);
        ArrayList l = new ArrayList();
        ArrayList al = new ArrayList();
        ArrayList arr = new ArrayList();
        int sum = 0;
        int n = Integer.parseInt(dis.readLine());
        String s = dis.readLine();
        Pattern p = Pattern.compile("\\s");
        String[] s2 = p.split(s);
        for(String s1 : s2){
            l.add(Integer.parseInt(s1));
        }
        Iterator it = l.iterator();
        while(it.hasNext()){
        	int x = (int)it.next();
            if(!al.contains(x)){
                al.add(x);
            }
        }
        Iterator itr = al.iterator();
        while(itr.hasNext()){
        	int t = (int)itr.next();
            sum = sum + ((int)Collections.frequency(l,t))/2;
            arr.add(Collections.frequency(l,t));
        }
        System.out.println(al);
        System.out.println(arr);
        System.out.println(sum);
        
    }

}
