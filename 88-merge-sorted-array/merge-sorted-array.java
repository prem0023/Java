class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;

        while(n > 0){
            if(m > 0 && nums1[m-1] >= nums2[n-1]){
                nums1[p] = nums1[m-1];
                m--;
            } else{
                nums1[p] = nums2[n-1];
                n--;
            }
            p--;
        }
    }
}