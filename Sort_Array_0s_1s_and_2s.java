// Sort an array of 0s, 1s and 2s

class Solution
{
    public static void sort012(int arr[], int n)
    {
        // code here 
        int l = 0;
        int m = 0;
        int h = n-1;
        int temp = 0;
        
        while(m<=h){
            switch(arr[m]){
                case 0: {
                    temp = arr[l];
                    arr[l] = arr[m];
                    arr[m] = temp;
                    l++;
                    m++;
                    break;
                }
                case 1 : {
                    m++;
                    break;
                }
                case 2 : {
                    temp = arr[h];
                    arr[h] = arr[m];
                    arr[m] = temp;
                    h--;
                    break;
                }
            }
        }
    }
	
	public static void main(String[] args) {

		int[] arr = {0, 2, 1, 2, 0};
		
		sort012(arr, arr.length);
		
		for(int i : arr)
			System.out.println(i);

	}

}