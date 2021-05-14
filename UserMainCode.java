
import java.util.*;

public class UserMainCode {
	
	public int findLargeSmallDifference(int input1, int[] input2){
		Arrays.sort(input2);
		int d = input2[input1-1] - input2[0];
		return d;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		UserMainCode us = new UserMainCode();
		System.out.println(us.findLargeSmallDifference(n,arr));
	}

}
