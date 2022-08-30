// Method 1

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        List<Integer> list = new ArrayList<Integer>();
        
        int a = arr[N-1];
        int i = 0;
        
        for(i=N-2; i>=0; i--){
            if(a>arr[i])
                break;
            else
                a = arr[i];
        }
        
        if(i<0){
            for(i=N-1; i>=0; i--){
                list.add(arr[i]);
            }
            return list;
        }
        
        a = arr[i];
   
        for(int j=0;j<i;j++)
            list.add(arr[j]);
        
        for(int j=N-1; j>i;j--){
            if(arr[j] > a){
                arr[i] = arr[j];
                arr[j] = a;
                break;
            }
        }
        list.add(arr[i]);
        
        for(int j=N-1; j>i;j--)
            list.add(arr[j]);
            
    
        return list;
    }
}

/*
//Mathod 2
class Next_Permutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<=1 ||nums == null)
            return;
        
        int[] a = new int[n];
        int j=0; // 1 4 2 2 1
        for(int i=n-1;i>0;i--){
            if(nums[i] <= nums[i-1]){
                a[j] = nums[i];
                j++;
            }
            else{
                a[j] = nums[i];
                arrange(nums, a, i, n);
                return;
            }
        }
        sort(nums,0,n);
    }
    
   public static void arrange(int[] nums, int[] a, int i, int n){
        sort(a,0,n-i);
        int j=0;
        while(j<n-i){
            if(nums[i-1]< a[j]){
                int x = nums[i-1];
                nums[i-1] = a[j];
                a[j] = x;
                break;
            }
            j++;
        }
        j=0;
        while(i<n){
            nums[i] = a[j++];
            i++;
        }
    }
    
    static void sort(int[] arr, int i,int n){
        for(;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int x=arr[i+1];
                int j=i;
                while (j>=0 && arr[j] > x){
                	arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1]= x;
            }
        }
    }
}


// Mrthod 3
class Solution {
    public void nextPermutation(int[] nums) {
         //1 3 5 4 2 -> i=3, j=4; 1 4 5 3 2
        //   1 2 3 4 5. index = 4 -> 1 2 3 5 4 -> 4 is i, j is 5
    if(nums == null || nums.length == 1)  return;      
    int  i  = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0)
        {
            int j = nums.length - 1;
            while(j>0 && nums[j] <= nums[i])
            {
                j--;
            }

            swap(i, j, nums);
        }
        
        reverse(i+1, nums.length - 1, nums);
        
    }
    
    void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void reverse(int i, int j , int[] nums)
    {
        while(i < j)
        {
            swap(i++, j--, nums);
            
        }
    }
}
*/
