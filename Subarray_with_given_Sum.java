// Subarray with given sum

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        int sum =0;
		int start=0;
		int end =0;
		for(int i = 0; i < n; i++){
			
				sum=sum+arr[end];
				if(s==sum){
				    numbers.add(start+1);
				    numbers.add(end+1);
					break;
				}
				else if(sum>s){
					i=start++;
					end=start;
					sum=0;
				}
				else{
					end++;
				}
		}
		
		if(numbers.size()==0){
		    numbers.add(-1);
		}
		
		return numbers;
    }
}