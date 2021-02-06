package p1;

public class Container_Most_Water {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));

	}
	

	public static int maxArea(int[] height) {
		int area=0;
	    int i=0;
	    int j= height.length -1;
	    while(j>i){
	    	int l =  height[i] < height[j] ? height[i] : height[j];
	    	System.out.println(l);
	        if(area < l*(j-i)){
	        	area = l*(j-i);
	        }
	        if(height[i] < height[j])
	        	i++;
	        else
	        	j--;
	    }
	    return area;
	}
	

}
