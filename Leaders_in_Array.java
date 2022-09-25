// Leaders in an array

class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> leader = new ArrayList<>();

        

        int max = arr[n-1];

        

        leader.add(max);

        

        for(int i = n-2; i >= 0; i--)

      {

 

            if(max <= arr[i])

            {

                max = arr[i];

               leader.add(max);

            }

      }

        

        Collections.reverse(leader);

       

           return leader;
    }
}
