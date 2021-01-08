import java.io.*;
import java.util.*;


public class HourGlass {

    static int a[] = new int[16];
    static int sum = 0;
    static int k = 0;
    //static int result;
    //int sum2 = 0;

    static int hourglassSum(int[][] arr) {
        for(int i=0;i<=3;i++){
            for(int j=0;j<=3;j++){
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                a[k] = sum;
                System.out.println(a[k]);
                k++;
            }
        }
        for(int i=0;i<15;i++){
            if(a[0]>a[i+1]){
            
            }
            else{
                a[0] = a[i+1];
                
            }
        }
        return a[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        DataInputStream bufferedWriter = new DataInputStream(System.in);

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);

        bufferedWriter.close();

        scanner.close();
    }
}
/*
    1 1 1 0 0 0

    0 1 0 0 0 0

    1 1 1 0 0 0

    0 9 2 -4 -4 0

    0 0 0 -2 0 0

    0 0 -1 -2 -4 0
    o/p = 13
*/
