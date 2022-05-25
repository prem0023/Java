class Count_Pair_GivenSum {
//Count pairs with given sum
    int getPairsCount(int[] arr, int n, int k) {
        
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = n-1;
        while(i<j){
            if(arr[i]+arr[j] == k){
                if(arr[i] == arr[j]){
                    count = count + fact(j-i); 
                    return count;
                }
                else if(arr[i] == arr[i+1] && arr[j] == arr[j-1]){
                    int l = 2;
                    int r = 2;
                    i++;
                    j--;
                    while(arr[i] == arr[i+1]){
                        l++;
                        i++;
                    }
                    while(arr[j] == arr[j-1]){
                        r++;
                        j--;
                    }
                    count = count + l*r;
                    i++;
                    j--;
                    //System.out.println("l="+l+" r="+r);
                }
                else if(arr[i] == arr[i+1]){
                    i++;
                    count++;
                }
                else if(arr[j] == arr[j-1]){
                    j--;
                    count++;
                }
                else{
                    i++;
                    j--;
                    count++;
                }
            }
            else if(arr[i]+arr[j] > k)
                j--;
            else
                i++;
        }
        return count;
    }
    static int fact(int n){
        if(n==1)
            return 1;
        return n+fact(n-1);
    }
}