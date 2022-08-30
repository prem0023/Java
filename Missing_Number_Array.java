// Missing number in array

class Solution {
    int MissingNumber(int array[], int n) {
        // Your Code Here
        Arrays.sort(array);
        
        int i = 1;
        for(int x : array){
            if(i != x)
                return i;
            i++;
        }
        return i;
    }
	
	public static void main(String[] args) {

		int[] arr = {6,1,2,8,3,4,7,10,5};

		System.out.println(MissingNumber(arr));

	}
}