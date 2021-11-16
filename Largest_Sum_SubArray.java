
import java.util.*;

class Largest_Sum_SubArray
{
	static long maxSubarraySum(int arr[], int n){
        
        long sum = Integer.MIN_VALUE;
        long sum1 = sum;
        
        for(int i=0;i<n;i++){
            if(sum+arr[i] >= sum || sum <= arr[i]){
                if(sum+arr[i] > arr[i]) {
                	sum = sum+arr[i];
                }
                else {
                	sum = arr[i];
                }
            }
            else{
                if(sum1<sum){
                    sum1 = sum;
                }
                if(sum+arr[i]>0){
                   sum = sum+arr[i];
                }
                else {
                	if(sum>0) {
                		sum = 0;
                	}
                }
            }
            
        }
        if(sum>sum1){
            return sum;
        }
        return sum1;
        
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] arr = {-1,-2,-3,-4};
		System.out.println(maxSubarraySum(arr,4));
		sc.close();
	}
}

