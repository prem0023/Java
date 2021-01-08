package p1;

import java.util.Arrays;

class Rotate_Array {
	
	public static void main(String[] args) {
		int[] nums = {8,6,2,1,3};
		//System.out.println(n);
		rotate(nums,1);
		//int[] b = {6,2,1,3};
		System.out.println(Arrays.toString(nums));
		//System.out.println(Arrays.toString(b));
	}
	
	public static void rotate(int[] nums, int k) {
		 int n = nums.length;
	        int c=0;
	        int[] a = new int[n];
	        //System.out.print("[");
	       for(int i=0;i<n;i++){
	            if(n-k+i < n){
	                a[c++] = nums[n-k+i];             
	            }
	            else{
	                a[c++] = nums[i-k];        
	            }
	        }
	        for (int i=0;i<n;i++){
	            nums[i] = a[i];
	        }
	}
	
	
    public static void rotate_new(int[] nums, int k) {
        int n = nums.length;
        //int c=0;
        int i=0;
        System.out.print("[");
        for(i=0;i<n-1;i++){
            if(n-k+i < n){
               System.out.print(nums[n-k+i]+",");
                   
            }
            else{
                System.out.print(nums[i-k]+ ",");
            }
            
        }
        System.out.println(nums[i-k]+"]");
    }
}
