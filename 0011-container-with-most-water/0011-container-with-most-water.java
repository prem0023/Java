class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int ans = 0;
        
        while(start < end) {
            int temp = height[start] < height[end] ? height[start] : height[end];
            // int temp = Math.min(height[start], height[end]) * (end-start);
            // ans = Math.max(ans, temp*(end-start));
            ans = ans > temp*(end-start) ? ans : temp*(end-start);
            
            if(height[start] < height[end])
                start++;
            else
                end--;
        }
        
        
        return ans;
    }
}