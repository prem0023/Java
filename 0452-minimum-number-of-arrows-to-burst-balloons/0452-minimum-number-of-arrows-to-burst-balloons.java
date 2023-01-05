class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1])); //Sorting according to end

        int ans = 1;
        int bound = points[0][1];

        for(int i = 1; i<points.length; i++){
            //checking for non-overlapping range
            if(points[i][0] > bound){
                bound = points[i][1];
                ans++;
            }
        }
        return ans;
    }
}