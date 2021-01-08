import java.io.*;
import java.util.*;

public class SparseArray1
{
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException{
        DataInputStream dis = new DataInputStream(System.in);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] s = new String[N];
        for(int i=0;i<N;i++) {
        	s[i] = dis.readLine();
        }
        
        int query = sc.nextInt();
        String[] q = new String[query];
        for(int i=0;i<query;i++) {
        	q[i] = dis.readLine();
        }
        
        int c=0;
        for(int i=0;i<query;i++) {
        	for(int j=0;j<N;j++) {
        		//System.out.println(s[j]+" "+q);
        		if(q[i].equals(s[j])) {	
        			c++;
        		}
        	}
        	System.out.println(c);
        	c=0;
        	
        }
        sc.close();
        
    }

}


/*
 import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int[] matchingStrings(String[] strings, String[] queries) {

        int c = 0;
        int q = queries.length;
        int s = strings.length;
        int a[] = new int[q];

        for(int i=0;i<q;i++){
            for(int j=0;j<s;j++){
                if(queries[i].equals(strings[j])){
                    c++;
                }
            }
            a[i] = c;
            c=0;
        }
        return a;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

*/