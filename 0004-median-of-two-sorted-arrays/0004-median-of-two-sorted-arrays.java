class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // Get the lengths of the two arrays
        int len1 = nums1.length;
        int len2 = nums2.length;

        // Set the range for binary search on nums1
        int left = 0;
        int right = len1;

        while (left <= right) {
            // Partition nums1 and nums2
            int partition1 = (left + right) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - partition1;

            // Find the maximum elements on the left of the partition
            int maxLeft1 = partition1 > 0 ? nums1[partition1 - 1] : Integer.MIN_VALUE;
            int maxLeft2 = partition2 > 0 ? nums2[partition2 - 1] : Integer.MIN_VALUE;
            int maxLeft = Math.max(maxLeft1, maxLeft2);

            // Find the minimum elements on the right of the partition
            int minRight1 = partition1 < len1 ? nums1[partition1] : Integer.MAX_VALUE;
            int minRight2 = partition2 < len2 ? nums2[partition2] : Integer.MAX_VALUE;
            int minRight = Math.min(minRight1, minRight2);

            // Check if the partition is correct
            if (maxLeft <= minRight) {
                // If the total length is even, return the average of the two middle elements
                if ((len1 + len2) % 2 == 0) {
                    return (maxLeft + minRight) / 2.0;
                }
                // If the total length is odd, return the middle element
                else {
                    return maxLeft;
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        return 0.0; // This should not be reached, just to satisfy Java's return requirements
    }
}