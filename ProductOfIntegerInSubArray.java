package p1;
import java.util.*;

class ProductOfIntegerInSubArray {
	public static boolean find(int[] arr, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(arr[i]*arr[j] == arr[n]) {
					return true;
				}
			}
		}
		return false;
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	int c=0;
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	for(int i=0;i<n;i++) {
    		if(find(arr, i)) {
    			System.out.println(i);
    			return;
    		}
    	}
    	System.out.println(-1);
    	
    }
}