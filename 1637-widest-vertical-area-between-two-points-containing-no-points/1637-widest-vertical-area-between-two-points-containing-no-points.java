class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int ans = 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        for(int i=1; i<points.length; i++){
            ans = Math.max(ans, points[i][0]-points[i-1][0]);
        }
        
        return ans;
    }
}