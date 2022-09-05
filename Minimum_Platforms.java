// Minimum Platforms

//Method - 1
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        int max = 0;

        Arrays.sort(arr);
        Arrays.sort(dep);
        
        for(int i=0; i<n; i++){
            int x = getIndex(dep, 0, n-1, arr[i]);
            max = Math.max(max, i+1-x);
        }
        return max;
    }
    
    static int getIndex(int[] train, int i, int j, int target) {

		if (i >= j ) {
			if (train[i] >= target)
				return i;
			return i + 1;
		}

		int x = 0;
		int mid = i + (j - i) / 2;

		if (train[mid] >= target)
			x = getIndex(train, i, mid - 1, target);
		else
			x = getIndex(train, mid + 1, j, target);
		
		return x;
	}
    
}

/*

// Method - 2
static int findPlatform(int arr[], int dep[], int n)
   {
       int arrival = 0;
       int departure = 0;
       int max_paltform = 0;
       int currentPlatform = 0;
       Arrays.sort(arr);
       Arrays.sort(dep);
       while(arrival < n && departure < n){
           if(arr[arrival] <= dep[departure]){
               currentPlatform++;
               arrival++;
           }else{
               currentPlatform--;
               departure++;
           }
           max_paltform = Math.max(currentPlatform,max_paltform);
       }
       return max_paltform;
   }
*/