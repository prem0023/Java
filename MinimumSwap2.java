import java.io.*;
import java.util.*;

public class MinimumSwap2 {

    static int minimumSwaps(int[] arr) {
        int c = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i+1){

            }
            else{
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j] == i+1){
                        int x = arr[j];
                        arr[j] = arr[i];
                        arr[i] = x;
                        c++;
                        break;
                    }
                }
            }
        }
        return c;

    }

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
    	
        DataInputStream dis = new DataInputStream(System.in);
        
        int n = Integer.parseInt(dis.readLine());
        int[] arr = new int[n];
        String[] arrItems = dis.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        System.out.println(minimumSwaps(arr));


        scanner.close();
    }
}
