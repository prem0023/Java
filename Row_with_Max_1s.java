//Row with Max 1s

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int row = 0;
        int cmax = 0;
        
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=m-1;j>=0;j--){
                if(arr[i][j] == 1)
                    count++;
                else
                    break;
            }
            if(count == m)
                return i;
            else if(cmax < count){
            	row = i;
                cmax = count;
            }
        }
        if(cmax == 0)
            return -1;
        return row;
    }
}

/*
class Solution {
    public int findIndexOfOne(int[] A,int n)
    {
        int lo=0;
        int hi=n-1;
        
        while(lo<=hi)
        {
              int mid =lo+(hi-lo)/2;
           
              if(A[mid]==0)
              {
                  lo=mid+1;
                  
              }
              else 
                 hi=mid-1;
        }
        
        return lo;
    }//find the index of first occurance of one 
    int rowWithMax1s(int arr[][], int n, int m) {
    
     int ans=0;
     int max=0;
    for(int i=0;i<n;i++)
    {
         int firstIndex=findIndexOfOne(arr[i],m);
         int count=m-firstIndex;
         if(count>max)
         {
             ans=i;
             max=count;
         }
           
           
    }
    return (max==0)?-1:ans;
    }
}
*/