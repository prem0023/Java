// Frequencies of Limited Range Array Elements

class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        int max = P + 2;
        for(int i=0; i<N; i++){
            int idx = arr[i]%max;
            if(idx>N)
                continue;
            arr[idx-1] = arr[idx-1] + max;
        }
        for(int i=0; i<N; i++){
            arr[i] = arr[i]/max;
        }
    }
}