
import java.util.Scanner;

public class ArrayManipulation {

    @SuppressWarnings("resource")
	public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        
//This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
        long[] arr = new long[n];
        
        int lower;
        int upper;
        long sum;

        //for(int i=0;i<n;i++) arr[i]=0;

        for(int i=0;i<m;i++){
            lower=scan.nextInt();
            upper=scan.nextInt();
            sum=scan.nextInt();
            arr[lower-1]+=sum;
            if(upper<n) arr[upper]-=sum; 
        }
        
        long max=0;
        long temp=0;

        for(int i=0;i<n;i++){
        temp += arr[i];
        if(temp> max) max=temp;
        }

        System.out.println(max);

    }
}


	
	
/*
    static void arrayManipulation(int n, int[][] queries) {
    	long[] a = new long[n];
        long x = queries.length;
        //System.out.println(x);
        for(int i=0;i<x;i++){
            for(int j=queries[i][0]-1;j<=queries[i][1]-1;j++){
                //System.out.println(queries[i][2]);
                a[j] = a[j]+queries[i][2];
                
            }
        }
        for(int i=0;i<a.length;i++) {
            if(a[0]<a[i]) {
                a[0] = a[i];
            }
        }
        System.out.println(a[0]);
        

    }


    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
    	DataInputStream dis = new DataInputStream(System.in);

        String[] nm = dis.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = dis.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        arrayManipulation(n, queries);

    }

*/

//METHOD - 2
/*
public static void main(String[] args) throws IOException {
DataInputStream dis = new DataInputStream(System.in);

String[] nm = dis.readLine().split(" ");

int n = Integer.parseInt(nm[0]);
long[] a = new long[n];

int m = Integer.parseInt(nm[1]);

int[][] queries = new int[m][3];

for (int i = 0; i < m; i++) {
    String[] queriesRowItems = dis.readLine().split(" ");

    for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
    }
    for(int j=queries[i][0]-1;j<=queries[i][1]-1;j++){
        //System.out.println(queries[i][2]);
        a[j] = a[j]+queries[i][2];
        
    }
}
for(int i=0;i<a.length;i++) {
    if(a[0]<a[i]) {
        a[0] = a[i];
    }
}
System.out.println(a[0]);

}
*/