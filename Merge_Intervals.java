import java.util.*;

class Merge_Intervals
{
	public static void merge(int[][] intervals) {
        int n = intervals.length;
	if(n == 1){
            return intervals;
        }
        int k=0;
        int c=1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] x = new int[n][2];
        x[k][0] = intervals[0][0];
        x[k][1] = intervals[0][1];
        
        for(int i=1;i<n;i++){
            if(x[k][1] >= intervals[i][0]){
                if(intervals[i][1] <= x[k][1]){
                    continue;
                }
                x[k][1] = intervals[i][1];
            }
            else{
            	c++;
                k++;
                x[k][0] = intervals[i][0];
                x[k][1] = intervals[i][1];
                
            }
        }
        //System.out.println(c);
        int[][] z = new int[c][2];
        for(int i=0;i<c;i++) {
        	z[i] = x[i];
        }
        System.out.println(Arrays.deepToString(z));
    }
	
	public static void main(String[] args){
		int[][] arr = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
		merge(arr);
	}
}


/*
 * 		int[] slice = Arrays.copyOfRange(arr, startIndex, endIndex);
 */


