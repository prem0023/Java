// Rotate Array by d

class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
         int m=-1;

        d=d%n;

        for(int i=0;i<n;i++)

        {

            m=Math.max(m,arr[i]);

        }

        m++;

        for(int i=0;i<n;i++)

        {

            if(i>=d)

                arr[(i-d)]+=(arr[i]%m)*m;

            else

                arr[(n+i-d)]+=(arr[i]%m)*m;

        }

        for(int i=0;i<n;i++)

        {

            arr[i]=arr[i]/m;

        }

    }
}