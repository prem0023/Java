// Subarray with 0 sum

class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        hm.put(arr[0], 1);
        
        for(int i=1; i<n; i++){
            arr[i] = arr[i] + arr[i-1];
            if(hm.get(arr[i]) != null || arr[i] == 0)
                return true;
            hm.put(arr[i], 1);
        }
        return false;
    }
}