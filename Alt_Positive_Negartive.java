//Alternate positive and negative numbers

class Alt_Positive_Negartive {
    void rearrange(int arr[], int n) {
        int i = 0;
        while(i<n){
            if(i%2 == 0){
                if(arr[i]<0){
                    int k = findPositive(arr,i+1,n);
                    if(k<0)
                        return;
                    int c = arr[k];
                    while(k>i){
                        arr[k] = arr[k-1];
                        k--;
                    }
                    arr[i] = c;
                }
                
            }
            else{
                if(arr[i]>=0){
                    int k = findNegative(arr,i+1,n);
                    if(k<0)
                        return;
                    int c = arr[k];
                    while(k>i){
                        arr[k] = arr[k-1];
                        k--;
                    }
                    arr[i] = c;
                }
            }
            i++;
        }
    }
    
    static int findPositive(int[] arr,int i,int n){
        while(i<n){
            if(arr[i]>=0)
                return i;
            i++;
        }
        return -1;
    }
    
    static int findNegative(int[] arr,int j,int n){
        while(j<n){
            if(arr[j]<0)
                return j;
            j++;
        }
        return -1;
    }
}