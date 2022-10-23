// Element with left side smaller and right side greater

class Compute {
    public int findElement(int arr[], int n){
        int minFromRight[] = new int[n-2];
        int maxLeft = arr[0], minRight = Integer.MAX_VALUE;
        for(int i=n-1;i>1;--i) {
            if(arr[i] < minRight) {
                minRight = arr[i];
            }
            minFromRight[i-2] = minRight;
        }
        for(int i=1;i<n-1;++i) {
            if(arr[i] >= maxLeft) {
                maxLeft = arr[i];
                if(arr[i] <= minFromRight[i-1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
}