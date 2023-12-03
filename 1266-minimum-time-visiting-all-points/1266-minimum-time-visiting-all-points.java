class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        
        for(int i=1; i<points.length; i++){
            int x_diff = Math.abs(points[i][0] - points[i-1][0]);
            int y_diff = Math.abs(points[i][1] - points[i-1][1]);
            
            ans += Math.max(x_diff, y_diff);
        }
        
        return ans;
    }
}