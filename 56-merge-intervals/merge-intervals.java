class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> merged = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int x = intervals[0][0], y = intervals[0][1];
        if(n == 1){
            return intervals;
        }
        merged.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        
        for(int i=1; i<n; i++){
            List<Integer> inner = new ArrayList<>();

            if(intervals[i][1] >= y && (intervals[i][0] <= x || intervals[i][0] <= y)){
                merged.remove(merged.size()-1);
                inner.add(intervals[i][0] <= x ? intervals[i][0] : x);
                inner.add(intervals[i][1] >= y ? intervals[i][1] : y);
            }
            else if(intervals[i][1] < y && (x <= intervals[i][0] || x <= intervals[i][1])){
                merged.remove(merged.size()-1);
                inner.add(intervals[i][0] < x ? intervals[i][0] : x);
                inner.add(intervals[i][1] > y ? intervals[i][1] : y);
            }
            else{
                inner.add(intervals[i][0]);
                inner.add(intervals[i][1]);
            }
            merged.add(inner);
            x = inner.get(0);
            y = inner.get(1);
        }

        return merged.stream().map(innerList -> innerList.stream()
        .mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
    }
}