package p1;
import java.util.*;

class Minimise_Height
{
	static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int smallest = arr[0] + k, largest = arr[n-1]-k;
        for(int i = 0; i < n-1; i++){
            int min = Math.min(smallest, arr[i+1]-k);
            int max = Math.max(largest, arr[i]+k);
            if(min < 0) 
                continue;
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] arr = {6, 1, 9, 1, 1, 7, 9, 5, 2, 10};
		System.out.println(getMinDiff(arr,10,4));
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}

