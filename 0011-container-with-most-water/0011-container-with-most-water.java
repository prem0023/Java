class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int i=0;
        int j= height.length -1;
        while(j>i){
            int l =  height[i] < height[j] ? height[i] : height[j];
            if(area < l*(j-i))
                area = l*(j-i);

            if(height[i] < height[j])
	        	i++;
	        else
	        	j--;
        }
        return area;
    }
}