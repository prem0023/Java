package p1;

import java.util.Arrays;

//import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] a = {1,1,2,2,3,4};
		int n = removeDuplicates(a);
		System.out.println(n);
		System.out.println(Arrays.toString(a));
	}
	
	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
        int j=0;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[j]){  
                j++;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                //System.out.println(j);
            }
        }
        j++;
        System.out.println(j);
        return (j);
    }
}
