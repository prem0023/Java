// Equilibrium Point

class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        long sum =0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
        }
        long left_sum=0;
        for(int j=0;j<n;j++)
        {
            long right_sum =sum-arr[j];
            if(left_sum == right_sum)
            {
            return j+1;
            }
            left_sum = left_sum + arr[j];
            sum = sum - arr[j];
        }
        return -1;
    }
}
