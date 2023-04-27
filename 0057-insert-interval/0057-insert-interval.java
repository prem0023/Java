class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = intervals.length;
        
        for(int i=0; i<n; i++){
            if(newInterval[1] < intervals[i][0]){
                list.add(newInterval);
                int[][] ans = new int[list.size() + n-i][2];
                int k=0;
                for(int[] x : list){
                    ans[k][0] = x[0];
                    ans[k++][1] = x[1];
                }
                // System.out.println(ans.length+ " " + k);
                while(i < n){
                    ans[k][0] = intervals[i][0];
                    ans[k++][1] = intervals[i][1];
                    i++;
                }
                
                return ans;
            }
            else if(newInterval[0] > intervals[i][1])
                list.add(intervals[i]);
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        int k=0;
        int[][] ans = new int[list.size() + 1][2];
        
        for(int[] x : list){
            ans[k][0] = x[0];
            ans[k++][1] = x[1];
        }
        
        ans[k][0] = newInterval[0];
        ans[k++][1] = newInterval[1];
        
        return ans;
    }
}